package com.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    @ParameterizedTest
    @ValueSource(strings = {"Sabrina", "Dora", "Lola"})
    void valueSourceDemonstration(String petName) {
        assertNotNull(petName);
    }
}
