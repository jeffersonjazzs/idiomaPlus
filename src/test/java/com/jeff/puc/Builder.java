package com.jeff.puc;

import java.util.Set;

import com.jeff.puc.domain.Class;
import com.jeff.puc.domain.Student;
import com.jeff.puc.domain.Teacher;
import com.jeff.puc.dto.ClassDTO;
import com.jeff.puc.dto.StudentDTO;
import com.jeff.puc.dto.TeacherDTO;

public class Builder {
    public static Teacher teacher1() {
        Teacher model = new Teacher();

        model.setId(1l);
        model.setName("Teacher");
        model.setEmail("Email");
        model.setPhone("0012122121");
        model.setSalary(3000.0);

        return model;
    }

    public static TeacherDTO teacherDTO1() {
        TeacherDTO model = new TeacherDTO();

        model.setId(1l);
        model.setName("Teacher");
        model.setEmail("Email");
        model.setPhone("0012122121");
        model.setSalary(3000.0);

        return model;
    }

    public static Student student1() {
        Student model = new Student();

        model.setId(1l);
        model.setName("Teacher");
        model.setEmail("Email");
        model.setPhone("0012122121");

        return model;
    }

    public static StudentDTO studentDTO1() {
        StudentDTO model = new StudentDTO();

        model.setId(1l);
        model.setName("Teacher");
        model.setEmail("Email");
        model.setPhone("0012122121");

        return model;
    }

    public static Class class1() {
        Class model = new Class();

        model.setId(1l);
        model.setGrade(1);
        model.setTeacher(Builder.teacher1());
        model.setStudents(Set.of(Builder.student1()));

        return model;
    }

    public static ClassDTO classDTO1() {
        ClassDTO dto = new ClassDTO();

        dto.setId(1l);
        dto.setGrade(1);
        dto.setTeacher(Builder.teacherDTO1());
        dto.setStudents(Set.of(Builder.studentDTO1()));

        return dto;
    }


}
