package com.kushneruk.vitaliy.serverfamilydo.model.users;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select * from user where userName = :userName")
    Optional<User> findByUsername(@Param("userName") String userName);
}
