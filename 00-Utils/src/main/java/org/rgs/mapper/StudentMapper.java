package org.rgs.mapper;

import org.rgs.domain.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> findAllStudents();

    Student findStudentsById(int studentId);

    Double findGradeByName(String name);

    void insertStudent(Student student);


    void updateStudent(Student student);


}
