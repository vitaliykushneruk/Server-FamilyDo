package com.kushneruk.vitaliy.serverfamilydo.persistence.dao;

import com.kushneruk.vitaliy.serverfamilydo.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
 User findUserByUserName(String userName);
}
