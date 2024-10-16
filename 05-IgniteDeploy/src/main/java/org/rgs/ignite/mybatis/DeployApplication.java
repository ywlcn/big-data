package org.rgs.ignite.mybatis;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.services.ServiceConfiguration;
import org.rgs.ignite.mybatis.service.GreetingService;
import org.rgs.ignite.mybatis.service.impl.GreetingServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@SpringBootApplication
public class DeployApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        URL url = DeployApplication.class.getClassLoader().getResource("ignite-client.xml");

        Ignite ignite = Ignition.start(url);

        // 部署服务
        ServiceConfiguration svcCfg = new ServiceConfiguration();
        svcCfg.setName("GreetingService");
        svcCfg.setMaxPerNodeCount(1);
        svcCfg.setService(new GreetingServiceImpl());

        ignite.services().deploy(svcCfg);

        GreetingService greetingService = ignite.services().serviceProxy("GreetingService", GreetingService.class, false);
        String greeting = greetingService.greet("Alice");

        System.out.println("Greeting: " + greeting);

        // 关闭 Ignite 客户端
        ignite.close();

    }
}
