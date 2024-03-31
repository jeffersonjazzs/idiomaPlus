package com.jeff.puc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jeff.puc.dto.LessonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateTime;
	private String content;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassLesson classLesson;

	public Lesson(LessonDTO dto) {
		this.id = dto.getId();
		this.dateTime = dto.getDateTime();
		this.content = dto.getContent();

	}

}
