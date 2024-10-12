package org.rgs.demo.ignite.springdata;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableIgniteRepositories
@Import({IgniteClientAutoConfiguration.class})
public class IgniteSpringDataDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgniteSpringDataDemoApplication.class, args);
    }

}