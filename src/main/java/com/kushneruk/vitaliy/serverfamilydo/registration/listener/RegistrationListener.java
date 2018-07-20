package com.kushneruk.vitaliy.serverfamilydo.registration.listener;

import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import com.kushneruk.vitaliy.serverfamilydo.registration.OnRegistrationCompleteEvent;
import com.kushneruk.vitaliy.serverfamilydo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event){
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        userService.createVerificationTokenForUser(user, token);
        final SimpleMailMessage email = constructEmailMessage(event, user, token);
        javaMailSender.send(email);
    }

    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm/" + token;
        final String message = "Click for confirm";
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        return email;
    }
}
