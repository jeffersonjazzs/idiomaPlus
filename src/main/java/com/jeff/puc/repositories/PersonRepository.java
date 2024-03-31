package com.jeff.puc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeff.puc.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByEmail(String email);

}
