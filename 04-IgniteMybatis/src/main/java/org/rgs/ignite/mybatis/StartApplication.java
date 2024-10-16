package org.rgs.ignite.mybatis;

//import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//@ImportResource(locations={"classpath:ignite-config.xml"})
//@MapperScan(basePackages = {"org.rgs.ignite.mybatis.mapper"},
//        sqlSessionTemplateRef = "sqlSessionTemplate",
//        sqlSessionFactoryRef = "sqlSessionFactory")
@Import({IgniteClientAutoConfiguration.class})
@MapperScan(basePackages = "org.rgs.mapper", sqlSessionFactoryRef = "sqlSessionFactory")

//@Import({IgniteAutoConfiguration.class})
public class StartApplication{

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
