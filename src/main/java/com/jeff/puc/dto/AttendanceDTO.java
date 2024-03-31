package com.jeff.puc.dto;

import java.time.LocalDateTime;

import com.jeff.puc.domain.Attendance;
import com.jeff.puc.domain.Lesson;
import com.jeff.puc.domain.Student;
import com.jeff.puc.domain.enums.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
	private Long id;
	private LocalDateTime dateTime;
	private AttendanceStatus status;
	private Student student;
	private Lesson lesson;

	public AttendanceDTO(Attendance model) {
		this.id = model.getId();
		this.dateTime = model.getDateTime();
		this.status = model.getStatus();
		this.student = model.getStudent();
		this.lesson = model.getLesson();

	}
}
