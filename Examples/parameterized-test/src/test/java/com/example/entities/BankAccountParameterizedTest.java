package com.example.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BankAccountParameterizedTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        this.bankAccount = new BankAccount("Jefté", "Goes", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    private static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of(100.00, true, 1100.00),
                Arguments.of(200.00, true, 1200.00),
                Arguments.of(325.14, true, 1325.14),
                Arguments.of(489.33, true, 1489.33),
                Arguments.of(1000.00, true, 2000.00)
        );
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    public void shouldDepositCorrectAmountFromMethodSource(double amount, boolean branch, double expected) {
        bankAccount.deposit(amount, branch);
        Assertions.assertEquals(expected, bankAccount.getBalance(), 0.01);
    }

    // The name of method is the same as the method source.
    // It is not necessary to pass the name of the method as a parameter to the @MethodSource annotation.
    @ParameterizedTest
    @MethodSource()
    public void testConditions(double amount, boolean branch, double expected) {
        bankAccount.deposit(amount, branch);
        Assertions.assertEquals(expected, bankAccount.getBalance(), 0.01);
    }
}
