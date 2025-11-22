package nh.demo.testconfiguration.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultHelloServiceTest {

    @Autowired
    HelloService helloService;

    @TestConfiguration
    static class MyTestConfiguration {

        @Bean
        @Primary
        HelloService helloService() {
            var helloService = new HelloService("Spring");
            return helloService;
        }
    }


    @Nested
    class TestBean {

        @Test
        void test_bean_nested() {
            assertEquals("Spring", helloService.getGreeting());
        }
    }

    @Test
    void test_bean() {
        assertEquals("Spring", helloService.getGreeting());
    }
}