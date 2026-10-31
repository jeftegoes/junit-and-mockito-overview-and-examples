package com.example.entities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @DisplayName("Test 2 * 2 = 4")
    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    public void mustMultiplyTwoValues() {
        int valueA = 2;
        int valueB = 2;
        int expected = 4;

        int result = calculator.multiply(valueA, valueB);

        assertEquals(expected, result, "The multiplication of " + valueA + " and " + valueB + " shouldn't be different from " + expected);
    }

    @DisplayName("Test 2 * 2 != 4")
    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
    public void shouldNotMultiplyCorrectly(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());

        int valueA = 2;
        int valueB = 2;
        int expected = 5;

        int result = calculator.multiply(valueA, valueB);

        assertNotEquals(expected, result, "The multiplication of " + valueA + " and " + valueB + " shouldn't be different from " + expected);
    }
}
