package com.kushneruk.vitaliy.serverfamilydo.persistence.dao;

import com.kushneruk.vitaliy.serverfamilydo.persistence.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository  extends JpaRepository<VerificationToken, Long> {
}
