package org.rgs.ignite.mybatis.service;


import org.rgs.domain.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudents();

    public void insertStudent(Student student);

    public void doTransactionalError(Student student);

}
