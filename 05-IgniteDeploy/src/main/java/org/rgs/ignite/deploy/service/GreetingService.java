package org.rgs.ignite.deploy.service;

import org.apache.ignite.services.Service;

public interface GreetingService extends Service {
    String greet(String name);
}