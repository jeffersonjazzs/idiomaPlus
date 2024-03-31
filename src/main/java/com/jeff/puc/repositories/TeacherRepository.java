package com.jeff.puc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeff.puc.domain.Teacher;
import com.jeff.puc.dto.TeacherDTO;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    boolean existsByEmail(String email);

    Page<Teacher> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
 
}
