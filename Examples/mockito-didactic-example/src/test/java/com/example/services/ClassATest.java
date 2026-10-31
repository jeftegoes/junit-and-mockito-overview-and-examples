package com.example.services;

import com.example.models.ClassA;
import com.example.models.ClassB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClassATest {
    @InjectMocks
    ClassA classA;

    @Mock
    ClassB classB;

    @BeforeEach
    void setup() {

    }

    @Test
    void sumTwoValuesTest() {
        Mockito.when(classB.getX()).thenReturn(20);

        assertEquals(25, classA.sumValues());
    }
}