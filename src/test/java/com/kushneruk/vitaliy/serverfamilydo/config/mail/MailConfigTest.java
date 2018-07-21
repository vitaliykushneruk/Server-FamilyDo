package com.kushneruk.vitaliy.serverfamilydo.config.mail;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static com.kushneruk.vitaliy.serverfamilydo.config.mail.MailConfig.*;
import static org.junit.Assert.assertEquals;

public class MailConfigTest extends TestContextConfiguration {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Value("${app.mail.host}")
    String host;

    @Value("${app.mail.port}")
    Integer port;

    @Value("${app.mail.protocol}")
    String protocol;

    @Value("${app.mail.username}")
    String username;

    @Value("${app.mail.password}")
    String password;

    @Value("${app.mail.properties.mail.transport.protocol}")
    String transportProtocol;

    @Value("${app.mail.properties.mail.smtps.auth}")
    String smtpsAuth;

    @Value("${app.mail.properties.mail.smtps.starttls.enable}")
    String smtpsStarttlsEnable;

    @Value("${app.mail.properties.mail.smtps.timeout}")
    String smtpsTimeout;

    @Ignore
    @Test
    public void getMailHost() {
        assertEquals(javaMailSender.getHost(), host);
    }

    @Ignore
    @Test
    public void getMailPort() {
        assertEquals(javaMailSender.getPort(), port.intValue());
    }

    @Ignore
    @Test
    public void getMailProtocol() {
        assertEquals(javaMailSender.getProtocol(), protocol);
    }

    @Ignore
    @Test
    public void getMailUsername() {
        assertEquals(javaMailSender.getUsername(), username);
    }

    @Ignore
    @Test
    public void getMailPassword() {
        assertEquals(javaMailSender.getPassword(), password);
    }

    @Ignore
    @Test
    public void getPropertiesMailTransportProtocol() {
        assertEquals(javaMailSender.getJavaMailProperties().getProperty(MAIL_TRANSPORT_PROTOCOL), transportProtocol);
    }

    @Ignore
    @Test
    public void getPropertiesMailSmtpsAuth() {
        assertEquals(javaMailSender.getJavaMailProperties().getProperty(MAIL_SMTPS_AUTH), smtpsAuth);
    }

    @Ignore
    @Test
    public void getPropertiesMailSmtpsStarttlsEnable() {
        assertEquals(javaMailSender.getJavaMailProperties().getProperty(MAIL_SMTPS_STARTTLS_ENABLE), smtpsStarttlsEnable);
    }

    @Ignore
    @Test
    public void getPropertiesMailSmtpsTimeout() {
        assertEquals(javaMailSender.getJavaMailProperties().getProperty(MAIL_SMTPS_TIMEOUT), smtpsTimeout);
    }
}