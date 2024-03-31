package com.jeff.puc.dto;

import com.jeff.puc.domain.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesDTO {

	private Long id;
	private String name;
	private String description;

	public CoursesDTO(Course model) {
		this.id = model.getId();
		this.name = model.getName();
		this.description = model.getDescription();
	}

}
