package com.jeff.puc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeff.puc.domain.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
