package com.jeff.puc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jeff.puc.domain.Contact;
import com.jeff.puc.domain.Student;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
