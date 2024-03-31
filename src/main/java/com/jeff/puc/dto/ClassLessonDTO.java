package com.jeff.puc.dto;

import java.time.LocalDateTime;

import com.jeff.puc.domain.ClassLesson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassLessonDTO {

	private Long id;
	private String title;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String description;

	public ClassLessonDTO(ClassLesson model) {
		this.id = model.getId();
		this.title = model.getTitle();
		this.startTime = model.getStartTime();
		this.endTime = model.getEndTime();
		this.description = model.getDescription();
	}
}
