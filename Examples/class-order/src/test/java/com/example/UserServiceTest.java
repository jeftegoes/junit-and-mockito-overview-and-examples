package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(1)
public class UserServiceTest {
    @BeforeAll
    static void setup() {
        System.out.println("Test methods related to UserService will be executed");
    }

    @Test
    void testUserService() {
        System.out.println("Executing test for UserService");
    }
}
