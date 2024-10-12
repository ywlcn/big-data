package com.rgs.ignite.hello.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.example.mapper")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource , MybatisProperties properties ) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // MyBatis の設定をプログラムで構成
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();

        //properties.getConfigLocation()

        // セカンドレベルキャッシュを有効化
        configuration.setCacheEnabled(true);
        configuration.setLocalCacheScope(org.apache.ibatis.session.LocalCacheScope.STATEMENT);

        // デフォルトのキャッシュ実装を IgniteMyBatisCache に設定
        // ただし、MyBatis はキャッシュをマッパーごとに設定するため、以下は一例です

        // マッパー XML またはアノテーションでキャッシュを指定する必要があります

        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }
}