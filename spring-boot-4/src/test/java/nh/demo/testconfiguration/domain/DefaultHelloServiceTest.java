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
            // ✅ WORKS in Spring Boot 3.5.x
            // ❌ FAILS in Spring Boot 4
            assertEquals("Spring", helloService.getGreeting());
        }
    }

    // ✅ WORKS in Spring Boot 3.5.x
    // ✅ WORKS in Spring Boot 4
    // (You can also remove this test method,
    // the nested test is still failing in Spring Boot 4)
    @Test
    void test_bean() {
        assertEquals("Spring", helloService.getGreeting());
    }
}