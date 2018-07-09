package com.kushneruk.vitaliy.serverfamilydo.persistence.dao;

import com.kushneruk.vitaliy.serverfamilydo.TestContextConfiguration;
import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import com.kushneruk.vitaliy.serverfamilydo.persistence.model.VerificationToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

public class VerificationTokenRepositoryTest extends TestContextConfiguration {

    public static final String TEST_STRING = "test_string";

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() {
        final User build = User.builder().build();
        userRepository.save(build);
    }

    @After
    public void tearDown() {
        verificationTokenRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void verificationTokenWithNullToken() {
        final User user = userRepository.findAll().get(0);
        VerificationToken verificationToken = VerificationToken.builder().user(user).build();
        verificationTokenRepository.save(verificationToken);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void verificationTokenWithNullUserId() {
        VerificationToken verificationToken = VerificationToken.builder().token(TEST_STRING).build();
        verificationTokenRepository.save(verificationToken);
    }

    @Test
    public void verificationTokenWithAllFields() {
        final User user = userRepository.findAll().get(0);
        VerificationToken verificationToken = VerificationToken.builder().user(user).token(TEST_STRING).build();
        verificationTokenRepository.save(verificationToken);
    }
}