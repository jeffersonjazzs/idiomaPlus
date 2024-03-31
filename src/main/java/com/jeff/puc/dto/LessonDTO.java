package com.jeff.puc.dto;

import java.time.LocalDateTime;

import com.jeff.puc.domain.Lesson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO {

	private Long id;
	private LocalDateTime dateTime;
	private String content;

	public LessonDTO(Lesson model) {
		this.id = model.getId();
		this.dateTime = model.getDateTime();
		this.content = model.getContent();
	}

}
