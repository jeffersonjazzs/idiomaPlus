package com.jeff.puc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jeff.puc.dto.ClassLessonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassLesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String description;

	// Relacionamento com a classe
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class aClass;

	public ClassLesson(ClassLessonDTO dto) {
		this.id = dto.getId();
		this.title = dto.getTitle();
		this.startTime = dto.getStartTime();
		this.endTime = dto.getEndTime();
		this.description = dto.getDescription();

	}

}