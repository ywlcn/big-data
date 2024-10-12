package com.rgs.ignite.hello;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class IgniteConfig {

//    @Bean
//    public Ignite igniteInstance() throws IgniteException {
//        IgniteConfiguration cfg = new IgniteConfiguration();
//        cfg.setClientMode(true); // 设置为客户端模式
//        cfg.setIgniteInstanceName("ignite-client");
//
//        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
//        ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
//        cfg.setDiscoverySpi(new TcpDiscoverySpi().setIpFinder(ipFinder));
//
//        // Caused by: class org.apache.ignite.IgniteCheckedException: Remote node has peer class loading enabled flag different from local
//        // https://www.cnblogs.com/yuezhikong/p/13529766.html
//        cfg.setPeerClassLoadingEnabled(true);
//
//        // 配置与服务器的发现 SPI
//        // 这里假设服务器和客户端在同一网络下，可以使用 TcpDiscoveryMulticastIpFinder 或 TcpDiscoveryVmIpFinder
//        // 例如使用 TcpDiscoveryVmIpFinder 指定服务器地址
//        // 配置请参考服务器端配置
//        return Ignition.start(cfg);
//    }
}
