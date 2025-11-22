package nh.demo.testconfiguration.domain;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private String greeting;

    HelloService() {
        this.greeting = "World";
    }

    public HelloService(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
