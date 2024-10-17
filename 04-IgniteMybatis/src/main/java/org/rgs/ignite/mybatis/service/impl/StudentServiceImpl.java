package org.rgs.ignite.mybatis.service.impl;

import org.rgs.domain.Student;
import org.rgs.ignite.mybatis.dao.StudentDao;
import org.rgs.ignite.mybatis.service.StudentService;
import org.rgs.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("igniteClientSpringTransactionManager")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    public List<Student> findAllStudents(){
        return dao.findAllStudents();
    }

    public void insertStudent(Student student){
        dao.insertStudent(student);
    }

    @Override
    public void doTransactionalError(Student student) {
        //dao.insertStudent(student);
        dao.updateStudent(student);
        throw new RuntimeException("ユーザーエラー");
    }


}
