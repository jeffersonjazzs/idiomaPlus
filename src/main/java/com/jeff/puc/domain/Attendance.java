package com.jeff.puc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jeff.puc.domain.enums.AttendanceStatus;
import com.jeff.puc.dto.AttendanceDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime dateTime;
    
    @Enumerated(EnumType.STRING)
    private AttendanceStatus status; // Enum: PRESENT, ABSENT, LATE
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    
 public Attendance(AttendanceDTO attendanceDTO) {
    	
        this.id = attendanceDTO.getId();
        this.dateTime =  attendanceDTO.getDateTime();
        this.status =  attendanceDTO.getStatus();
        this.student = attendanceDTO.getStudent();
        this.lesson = attendanceDTO.getLesson();
    }
   
}
