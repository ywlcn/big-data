package org.rgs.ignite.deploy.service.impl;

import org.rgs.ignite.deploy.service.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello, " + name + "! Greetings from " + org.apache.ignite.Ignition.ignite().name();
    }


}