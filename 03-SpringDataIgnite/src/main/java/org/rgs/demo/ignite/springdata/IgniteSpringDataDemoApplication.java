package org.rgs.demo.ignite.springdata;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableIgniteRepositories
public class IgniteSpringDataDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgniteSpringDataDemoApplication.class, args);
    }

}