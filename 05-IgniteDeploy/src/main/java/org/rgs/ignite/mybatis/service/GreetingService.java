package org.rgs.ignite.mybatis.service;

import org.apache.ignite.services.Service;

public interface GreetingService extends Service {
    String greet(String name);
}