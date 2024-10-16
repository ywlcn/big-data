package org.rgs.ignite.mybatis.service.impl;

import org.rgs.ignite.mybatis.service.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello, " + name + "! Greetings from " + org.apache.ignite.Ignition.ignite().name();
    }


}