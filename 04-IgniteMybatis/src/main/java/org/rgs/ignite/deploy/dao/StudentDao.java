package org.rgs.ignite.deploy.dao;

import org.rgs.ignite.deploy.domain.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> findAllStudents();
}
