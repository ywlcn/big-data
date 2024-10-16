package org.rgs.ignite.mybatis.dao.impl;

import org.rgs.domain.Student;
import org.rgs.ignite.mybatis.dao.StudentDao;
import org.rgs.mapper.StudentMapper;
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