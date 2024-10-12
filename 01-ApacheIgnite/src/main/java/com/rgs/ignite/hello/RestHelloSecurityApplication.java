package com.rgs.ignite.hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ignite.springframework.boot.autoconfigure.IgniteClientAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan(basePackages = {"com.rgs.ignite.hello"},
        annotationClass = Mapper.class)
@Import(IgniteClientAutoConfiguration.class)
public class RestHelloSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestHelloSecurityApplication.class, args);
    }


    // https://www.gridgain.com/docs/tutorials/spring/spring-ignite-tutorial#create-spring-data-repositories


//    https://github.com/GridGain-Demos/ignite-mysql-acceleration-demo
    // https://dzone.com/articles/apache-ignite-rdbms-integration
    // https://www.youtube.com/watch?v=Ymi-aY7Z0vA
//    @Bean
//    CommandLineRunner runner2() {
//        return new CommandLineRunner() {
//            /** IgniteClient instance. */
//            @Autowired
//            private IgniteClient client;
//
//            /** Method will be executed on application startup. */
//            @Override
//            public void run(String... args) throws Exception {
//                System.out.println("ServiceWithIgniteClient.run");
//                System.out.println("Cache names existing in cluster: " + client.cacheNames());
//
//
//                ClientCacheConfiguration c = new ClientCacheConfiguration();
//                c.setKeyConfiguration()
//
//
//                client.createCache(c)
//
//
//                ClientCache<Integer, Integer> cache = client.createCache("my-cache1");
//
//                //ClientCache<Integer, Integer> cache = client.cache("my-cache1");
//
//                System.out.println("Putting data to the my-cache1...");
//
//                cache.put(1, 1);
//                cache.put(2, 2);
//                cache.put(3, 3);
//
//                System.out.println("Done putting data to the my-cache1...");
//
//                for (String cacheName : client.cacheNames())
//                    System.out.println("        " + cacheName);
//
//            }
//        };
//    }
//
//
//    /**
//     * Service using autoconfigured Ignite.
//     *
//     * @return Runner.
//     */
////    @Bean
//    public CommandLineRunner runner() {
//        return new CommandLineRunner() {
//            /** Ignite instance. */
////            @Autowired
////            private Ignite ignite;
//
//            @Autowired
//            private IgniteClient com.rgs.ignite.hello.igniteClient;
//
//            /** Method will be executed on application startup. */
//            @Override
//            public void run(String... args) throws Exception {
//                System.out.println("ServiceWithIgnite.run:");
//                //This property comes from configurer. See AutoConfigureExample.
////                System.out.println("    IgniteConsistentId: " + ignite.configuration().getConsistentId());
////
////                //Other properties are set via application-node.yml.
////                System.out.println("    IgniteInstanceName: " + ignite.configuration().getIgniteInstanceName());
////                System.out.println("    CommunicationSpi.localPort: " +
////                        ((TcpCommunicationSpi)ignite.configuration().getCommunicationSpi()).getLocalPort());
////                System.out.println("    DefaultDataRegion initial size: " +
////                        ignite.configuration().getDataStorageConfiguration().getDefaultDataRegionConfiguration().getInitialSize());
////
////                DataRegionConfiguration drc =
////                        ignite.configuration().getDataStorageConfiguration().getDataRegionConfigurations()[0];
////
////                System.out.println("    " + drc.getName() + " initial size: " + drc.getInitialSize());
////                System.out.println("    Cache in cluster:");
//
////                for (String cacheName : ignite.cacheNames())
////                    System.out.println("        " + cacheName);
//
//                for (String cacheName : com.rgs.ignite.hello.igniteClient.cacheNames())
//                    System.out.println("        " + cacheName);
//                cacheAPI();
//                sqlAPI();
//            }
//
//            /** Example of the SQL API usage. */
//            private void sqlAPI() {
////                //This cache configured in `application.yml`.
////                IgniteCache<Long, Object> accounts = com.rgs.ignite.hello.igniteClient.cache("accounts");
////
////                //SQL table configured via QueryEntity in `application.yml`
////                String qry = "INSERT INTO ACCOUNTS(ID, AMOUNT, UPDATEDATE) VALUES(?, ?, ?)";
////
////                accounts.query(new SqlFieldsQuery(qry).setArgs(1, 250.05, new Date())).getAll();
////                accounts.query(new SqlFieldsQuery(qry).setArgs(2, 255.05, new Date())).getAll();
////                accounts.query(new SqlFieldsQuery(qry).setArgs(3, .05, new Date())).getAll();
////
////                qry = "SELECT * FROM ACCOUNTS";
////
////                List<List<?>> res = accounts.query(new SqlFieldsQuery(qry)).getAll();
////
////                for (List<?> row : res)
////                    System.out.println("(" + row.get(0) + ", " + row.get(1) + ", " + row.get(2) + ")");
//            }
//
//            /** Example of the Cache API usage. */
//            private void cacheAPI() {
////                //This cache configured in `application.yml`.
////                IgniteCache<Integer, Integer> cache = ignite.cache("my-cache2");
////
////                System.out.println("Putting data to the my-cache1...");
////
////                cache.put(1, 1);
////                cache.put(2, 2);
////                cache.put(3, 3);
////
////                System.out.println("Done putting data to the my-cache1...");
//            }
//        };
//    }
}
