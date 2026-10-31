package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(3)
public class OrderServiceTest {
    @BeforeAll
    static void setup() {
        System.out.println("Test methods related to OrderService will be executed");
    }

    @Test
    void testOrderService() {
        System.out.println("Executing test for OrderService");
    }
}
