package org.rgs.ignite.mybatis.dao;


import org.rgs.domain.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> findAllStudents();


    public void insertStudent(Student student);


    public void updateStudent(Student student);

}
