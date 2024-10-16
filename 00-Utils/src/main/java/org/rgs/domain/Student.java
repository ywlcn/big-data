package org.rgs.domain;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable{

    @QuerySqlField
    private Integer studId;

    @QuerySqlField(orderedGroups = {@QuerySqlField.Group(
            name = "student_ne_index", order = 0)})
    private String name;

    @QuerySqlField(orderedGroups = {@QuerySqlField.Group(
            name = "student_ne_index", order = 1)})
    private String email;

    @QuerySqlField
    private Date dob;

}
