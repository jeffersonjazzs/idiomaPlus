package com.jeff.puc.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeff.puc.domain.Student;
import com.jeff.puc.dto.StudentDTO;
import com.jeff.puc.email.SendEmailService;
import com.jeff.puc.messages.EmailMessages;
import com.jeff.puc.repositories.StudentRepository;
import com.jeff.puc.services.Util;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	 private final SendEmailService sendEmailService;

	public SendEmailService getSendEmailService() {
	 return sendEmailService;
	}

	public StudentService(StudentRepository studentRepository, SendEmailService sendEmailService) {
		this.studentRepository = studentRepository;
		 this.sendEmailService = sendEmailService;
	}

	@Transactional(rollbackFor = Exception.class)
	public StudentDTO insert(StudentDTO newStudentDTO) {
		String email = newStudentDTO.getEmail();
		if (this.studentRepository.existsByEmail(email)) {
			throw new RuntimeException("Email already exists");
		}

		Student model = new Student(newStudentDTO);
		model = this.studentRepository.save(model);
		newStudentDTO.setId(model.getId());

		try {
			 this.getSendEmailService().enviarEmailComAnexo(newStudentDTO.getEmail(),
			 EmailMessages.createTitle(newStudentDTO),
			 EmailMessages.messageToNewUserLogoStudent(newStudentDTO),
			 "/logo/logo-white.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newStudentDTO;
	}

	@Transactional(readOnly = true)
	public Page<StudentDTO> findAll(Pageable pageable) {
		return this.studentRepository.findAll(pageable).map(StudentDTO::new);
	}

	@Transactional(readOnly = true)
	public StudentDTO findById(Long id) {
		return new StudentDTO(this.findModel(id));
	}

	@Transactional(rollbackFor = Exception.class)
	public StudentDTO update(Long id, StudentDTO studentDTO) {
		StudentDTO fromDatabase = this.findById(id);
		Util.myCopyProperties(studentDTO, fromDatabase);
		this.studentRepository.save(new Student(fromDatabase));
		return studentDTO;
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Long id) {
		this.studentRepository.delete(this.findModel(id));
	}

	protected Student findModel(Long id) {
		return this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
	}

	public Page<StudentDTO> findByName(String name, Pageable pageable) {
		return this.studentRepository.findAllByNameContainsIgnoreCase(name, pageable).map(StudentDTO::new);
	}
}
