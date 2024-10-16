package com.rgs.ignite.hello.mapper;


import org.apache.ibatis.annotations.*;
import org.rgs.domain.Person;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Insert("""
            CREATE TABLE employees (
              id int(11) NOT NULL,
              name varchar(30) DEFAULT NULL,
              email varchar(30) DEFAULT NULL,
              PRIMARY KEY (id)
            ) ENGINE=MyISAM DEFAULT CHARSET=utf8;
            """)
    void createTable();

    @Select("SELECT * FROM Person WHERE id = #{id}")
    Person getPersonById(@Param("id") Long id);

    @Select("SELECT * FROM Person")
    List<Person> getAllPersons();

    @Insert("INSERT INTO Person (id, name, age) VALUES (#{id}, #{name}, #{age})")
    void insertPerson(Person person);

    @Update("UPDATE Person SET name = #{name}, age = #{age} WHERE id = #{id}")
    void updatePerson(Person person);

    @Delete("DELETE FROM Person WHERE id = #{id}")
    void deletePerson(@Param("id") Integer id);
}