package com.jeff.puc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeff.puc.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
