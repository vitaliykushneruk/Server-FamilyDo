package com.kushneruk.vitaliy.serverfamilydo.config.mail;

import com.kushneruk.vitaliy.serverfamilydo.infrastructure.property.Profiles;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@TestConfiguration
public class MailTestConfig {

    @Bean
    @Profile(Profiles.TEST)
    public JavaMailSenderImpl mailSender() {
        return Mockito.mock(JavaMailSenderImpl.class);
    }
}
