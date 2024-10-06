package org.rgs.ignite.data.dao;

import org.rgs.ignite.data.domain.Student;
import org.rgs.ignite.data.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cord on 2018/6/13.
 */
@Repository
public class StudentDao {

    @Autowired
    private StudentMapper mapper;

    public List<Student> findAllStudents(){
        return mapper.findAllStudents();
    }

}
