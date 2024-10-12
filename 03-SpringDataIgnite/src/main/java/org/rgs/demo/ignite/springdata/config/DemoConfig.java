package org.rgs.demo.ignite.springdata.config;

import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({IgniteClientAutoConfiguration.class})
public class DemoConfig {

//    @Bean(name = "igniteInstance")
//    public Ignite igniteInstance(Ignite ignite) {
//
//
//        return ignite;
//    }
//
//
//    @Bean
//    public IgniteConfigurer configurer() {
//        return igniteConfiguration -> {
//            igniteConfiguration.setClientMode(true);
//            TcpDiscoverySpi spi = new TcpDiscoverySpi();
//            spi.set
//            igniteConfiguration.setDiscoverySpi()
//        };
//    }
}