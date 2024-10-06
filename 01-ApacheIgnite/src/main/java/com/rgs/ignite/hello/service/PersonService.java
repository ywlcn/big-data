package com.rgs.ignite.hello.service;




import com.rgs.ignite.hello.mapper.PersonMapper;
import com.rgs.ignite.hello.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public Person getPersonById(Long id) {
        return personMapper.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personMapper.getAllPersons();
    }

    public void addPerson(Person person) {
        personMapper.insertPerson(person);
    }

    public void updatePerson(Person person) {
        personMapper.updatePerson(person);
    }

    public void deletePerson(Integer id) {
        personMapper.deletePerson(id);
    }
}