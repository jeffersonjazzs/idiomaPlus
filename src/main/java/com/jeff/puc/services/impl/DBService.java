package com.jeff.puc.services.impl;

import com.jeff.puc.repositories.ClassRepository;
import com.jeff.puc.repositories.StudentRepository;
import com.jeff.puc.repositories.TeacherRepository;

//@Service
public class DBService {
	private final ClassRepository classRepository;
	private final StudentRepository studentRepository;
	private final TeacherRepository teacherRepository;

	public DBService(ClassRepository classRepository, StudentRepository studentRepository,
			TeacherRepository teacherRepository) {
		this.classRepository = classRepository;
		this.studentRepository = studentRepository;
		this.teacherRepository = teacherRepository;
	}

	public void instantiateTestDatabase() {

	 
	}

}
