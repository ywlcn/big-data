package org.rgs.ignite.data.mapper;


import org.rgs.ignite.data.domain.Student;

import java.util.List;

/**
 *
 * @author cord
 * @date 2017/7/27
 */
public interface StudentMapper {

    List<Student> findAllStudents();

}
