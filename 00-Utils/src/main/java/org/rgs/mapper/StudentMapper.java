package org.rgs.mapper;

import org.rgs.domain.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> findAllStudents();

    /**
     * 根据studentId查询学生信息
     * @param studentId
     * @return Student
     */
    Student findStudentsById(int studentId);

    /**
     * 根据学生姓名查询学生分数
     * @param name
     * @return 学生分数
     */
    Double findGradeByName(String name);
}
