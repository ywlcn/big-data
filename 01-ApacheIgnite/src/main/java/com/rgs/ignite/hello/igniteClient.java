package com.rgs.ignite.hello;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.logger.java.JavaLogger;
import org.rgs.domain.Employee;

import javax.cache.Cache;
import java.util.Iterator;
import java.util.List;


public class igniteClient {

    public static void main1(String[] args) {
        IgniteConfiguration cfg = new IgniteConfiguration();
        JavaLogger slf4jLogger = new JavaLogger();
        cfg.setConsistentId("node2");
        cfg.setIgniteInstanceName("Ins2");
        cfg.setGridLogger(slf4jLogger);
        cfg.setClientMode(true);

        Ignite igniteClient = Ignition.start(cfg);

        IgniteCache<Integer, Employee> employeeCache = igniteClient.cache("EmployeeCache");
        employeeCache.put(5, new Employee(5, "emp5", "emp5@gmail.com"));
        Iterator<Cache.Entry<Integer, Employee>> iterator = employeeCache.iterator();
        if (!iterator.hasNext()) {
            System.out.println("No value found ");
        }
        iterator.forEachRemaining(d -> {
            System.out.printf("value for key %s is %s", d.getKey(), d.getValue());

        });
//        System.out.println("Employee value is " + employeeCache.get(3));
        igniteClient.close();

    }

    public static void main(String[] args) {

        ClientConfiguration cfg = new ClientConfiguration().setAddresses("127.0.0.1:10800");

        try (IgniteClient client = Ignition.startClient(cfg)) {
            ClientCache<Integer, String> cache = client.cache("personcache");

            List list =  cache.query(new SqlFieldsQuery(
                    "SELECT * FROM Person ")).getAll();

            cache.query(new SqlFieldsQuery(
                    "CREATE TABLE City (id int primary key, name varchar, region varchar)")).getAll();


            // Get data from the cache
        }



    }

}
