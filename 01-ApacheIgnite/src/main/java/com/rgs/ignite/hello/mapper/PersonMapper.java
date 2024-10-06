package com.rgs.ignite.hello.mapper;


import com.rgs.ignite.hello.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {

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