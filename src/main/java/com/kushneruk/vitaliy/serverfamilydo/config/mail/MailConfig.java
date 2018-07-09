package com.kushneruk.vitaliy.serverfamilydo.config.mail;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    public static final String MAIL_SMTPS_AUTH = "mail.smtps.auth";
    public static final String MAIL_SMTPS_STARTTLS_ENABLE = "mail.smtps.starttls.enable";
    public static final String MAIL_SMTPS_TIMEOUT = "mail.smtps.timeout";

    @Bean
    @ConfigurationProperties(prefix="app.mail")
    MailProperties mailProperties(){
        return new MailProperties();
    }

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailProperties().getHost());
        javaMailSender.setPort(mailProperties().getPort());
        javaMailSender.setProtocol(mailProperties().getProtocol());
        javaMailSender.setUsername(mailProperties().getUsername());
        javaMailSender.setPassword(mailProperties().getPassword());
        Properties properties = getProperties(javaMailSender);
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    private Properties getProperties(JavaMailSenderImpl javaMailSender) {
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put(MAIL_TRANSPORT_PROTOCOL, mailProperties().getProperties().get(MAIL_TRANSPORT_PROTOCOL));
        properties.put(MAIL_SMTPS_AUTH, mailProperties().getProperties().get(MAIL_SMTPS_AUTH));
        properties.put(MAIL_SMTPS_STARTTLS_ENABLE, mailProperties().getProperties().get(MAIL_SMTPS_STARTTLS_ENABLE));
        properties.put(MAIL_SMTPS_TIMEOUT, mailProperties().getProperties().get(MAIL_SMTPS_TIMEOUT));
        return properties;
    }
}

