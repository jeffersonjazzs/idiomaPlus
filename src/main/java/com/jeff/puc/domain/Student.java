package com.jeff.puc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.jeff.puc.dto.StudentDTO;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

    private Double fees;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Class classe;

    public Student(StudentDTO studentDTO) {
        super(studentDTO.getId(), studentDTO.getName(), studentDTO.getPhone(), studentDTO.getEmail(), studentDTO.getCep(), studentDTO.getStreet(),
                studentDTO.getNumber(), studentDTO.getDistrict(), studentDTO.getCity(), studentDTO.getState(), studentDTO.getCountry());
        this.fees = studentDTO.getFees();
    }

	 
}
