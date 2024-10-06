package com.rgs.ignite.hello.controller;

import com.rgs.ignite.hello.model.Person;
import com.rgs.ignite.hello.service.PersonService;
import com.rgs.ignite.hello.tasks.AddNumbersTask;
import com.rgs.ignite.hello.tasks.AddNumbersTaskArg;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.compute.ComputeTaskFuture;
import org.apache.ignite.lang.IgniteRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private Ignite ignite;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping
    public List<Person> getAllPersons() {
            for (String cacheName : ignite.cacheNames())
                    System.out.println("        " + cacheName);



        AddNumbersTaskArg arg = new AddNumbersTaskArg(111, 222);
        ComputeTaskFuture<Integer> future = ignite.compute().executeAsync(AddNumbersTask.class, arg);
        System.out.println(future.get());

//
//        Person p = new Person();
//        p.setId(111L);
//        p.setAge(10);
//        p.setName("name");
//
//        cache.put(1, p);
//
//        cache.get(1);
//

        // Get cluster-enabled executor service.
//        ExecutorService exec = ignite.executorService();
//
//// Iterate through all words in the sentence and create jobs.
//        for (final String word : "Print words using runnable".split(" ")) {
//            // Execute runnable on some node.
//            exec.submit(new IgniteRunnable() {
//                @Override
//                public void run() {
//
//                    System.out.println(">>> Printing '" + word + "' on this node from grid job.");
//                }
//            });
//        }

//        return new ArrayList<>();
        return personService.getAllPersons();
    }

    @PostMapping
    public String addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return "Person added successfully";
    }

    @PutMapping("/{id}")
    public String updatePerson(@PathVariable Integer id, @RequestBody Person person) {
        person.setId(id);
        personService.updatePerson(person);
        return "Person updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return "Person deleted successfully";
    }
}