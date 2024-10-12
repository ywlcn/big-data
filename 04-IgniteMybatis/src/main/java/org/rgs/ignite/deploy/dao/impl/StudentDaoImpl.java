package org.rgs.ignite.deploy.dao.impl;

import org.rgs.ignite.deploy.dao.StudentDao;
import org.rgs.ignite.deploy.domain.Student;
import org.rgs.ignite.deploy.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private StudentMapper mapper;

    public List<Student> findAllStudents(){
        return mapper.findAllStudents();
    }

}
