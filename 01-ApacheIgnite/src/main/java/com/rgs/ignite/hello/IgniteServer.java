package com.rgs.ignite.hello;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.BasicJdbcDialect;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.logger.java.JavaLogger;
import org.jetbrains.annotations.NotNull;
import org.rgs.domain.Employee;
import org.apache.ignite.cache.query.*;

import javax.cache.Cache;
import javax.cache.configuration.Factory;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.Iterator;

public class IgniteServer {

    public static void main(String[] args) throws IgniteException {
        // Preparing IgniteConfiguration using Java APIs
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setIgniteInstanceName("instance 1");
        JavaLogger slf4jLogger = new JavaLogger();
        cfg.setGridLogger(slf4jLogger);
        cfg.setClientMode(false);

        CacheConfiguration<Integer, Employee> empCache = new CacheConfiguration<>();
        empCache.setName("EmployeeCache");
        cfg.setCacheConfiguration(empCache);

        CacheJdbcPojoStoreFactory<Integer, Employee> factory = new CacheJdbcPojoStoreFactory<>();

        factory.setDialect(new BasicJdbcDialect());

        factory.setDataSourceFactory(getDataSourceFactory());

        JdbcType employeeType = getJdbcType();

        factory.setTypes(employeeType);

        empCache.setCacheStoreFactory(factory);
        empCache.setReadThrough(true);
        empCache.setWriteThrough(true);
        empCache.setWriteBehindEnabled(true);
        empCache.setWriteBehindFlushSize(2);
        empCache.setWriteBehindFlushFrequency(50000);
        Ignite ignite = Ignition.start(cfg);

        IgniteCache<Integer, Employee> empC = ignite.cache("EmployeeCache");
        empC.loadCache(null);
        Iterator<Cache.Entry<Integer, Employee>> iterator = empC.iterator();

        if (!iterator.hasNext()) {
            System.out.println("No value available");
        } else {
            iterator.forEachRemaining(d -> {
                System.out.printf("value for key %s is %s", d.getKey(), d.getValue());
            });
        }
        // Disconnect from the cluster.
//        ignite.close();


        IgniteCache<Integer, Employee> cache = ignite
                .getOrCreateCache(new CacheConfiguration<Integer, Employee>().setName("EmployeeCache"));

// Creating City table.
        cache.query(new SqlFieldsQuery(
                "CREATE TABLE City (id int primary key, name varchar, region varchar)")).getAll();



//        IgniteCache<Long, Employee> cache = ignite.cache("EmployeeCache");
//
//        SqlFieldsQuery sql = new SqlFieldsQuery(
//                "select id,name,email from employees");
//
//// Iterate over the result set.
//        try (QueryCursor<List<?>> cursor = cache.query(sql)) {
//            for (List<?> row : cursor)
//                System.out.println("employees=" + row.get(1) + row.get(2) );
//        }



    }

    @NotNull
    private static JdbcType getJdbcType() {
        JdbcType employeeType = new JdbcType();
        employeeType.setCacheName("EmployeeCache");
        employeeType.setDatabaseTable("employees");
        employeeType.setKeyType(Integer.class);
        employeeType.setKeyFields(new JdbcTypeField(Types.INTEGER, "id", Integer.class, "id"));
        employeeType.setValueFields(
                new JdbcTypeField(Types.INTEGER, "id", Integer.class, "id"),
                new JdbcTypeField(Types.VARCHAR, "name", String.class, "name"),
                new JdbcTypeField(Types.VARCHAR, "email", String.class, "email")
        );
        employeeType.setValueType(Employee.class);

        return employeeType;
    }

    private static Factory<DataSource> getDataSourceFactory() {
        return () -> {
            MysqlDataSource driverManagerDataSource = new MysqlDataSource();
            driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ignite-db");
            driverManagerDataSource.setUser("root");
            driverManagerDataSource.setPassword("123456");
            return driverManagerDataSource;
        };
    }

}
