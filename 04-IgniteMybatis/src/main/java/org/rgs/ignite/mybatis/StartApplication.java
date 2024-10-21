package org.rgs.ignite.mybatis;

//import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import org.apache.ignite.transactions.spring.IgniteClientSpringTransactionManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.ignite.IgniteJdbcDriver;

@SpringBootApplication
//@ImportResource(locations={"classpath:ignite-config.xml"})
//@MapperScan(basePackages = {"org.rgs.ignite.mybatis.mapper"},
//        sqlSessionTemplateRef = "sqlSessionTemplate",
//        sqlSessionFactoryRef = "sqlSessionFactory")
//@Import({IgniteClientAutoConfiguration.class})
@MapperScan(basePackages = "org.rgs.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
@Import({IgniteClientAutoConfiguration.class})
public class StartApplication{

    public static void main(String[] args) {
        ApplicationContext ap = SpringApplication.run(StartApplication.class, args);

        //HikariDataSource dataSource = ap.getBean(HikariDataSource.class);
        HikariDataSource dataSource = (HikariDataSource) ap.getBean("dataSource");

        dataSource.addDataSourceProperty(IgniteJdbcDriver.PROP_TX_ALLOWED,"true");


    }

    @Bean
    public IgniteClientSpringTransactionManager igniteClientSpringTransactionManager(IgniteClient cli) {
        IgniteClientSpringTransactionManager mgr = new IgniteClientSpringTransactionManager();

        mgr.setClientInstance(cli);

        return mgr;
    }

}
