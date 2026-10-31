package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class ProductServiceTest {
    @BeforeAll
    static void setup() {
        System.out.println("Test methods related to ProductService will be executed");
    }

    @Test
    void testProductService() {
        System.out.println("Executing test for ProductService");
    }
}
