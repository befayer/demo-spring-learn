package com.ssau.learn.dao;

import com.ssau.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.server.UID;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UID> {
    Optional<User> findByLogin(String login);
    Boolean existsByLoginOrEmail(String login, String email);
}
