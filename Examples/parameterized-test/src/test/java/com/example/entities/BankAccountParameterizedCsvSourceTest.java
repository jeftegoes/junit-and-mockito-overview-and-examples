package com.example.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountParameterizedCsvSourceTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        this.bankAccount = new BankAccount("Jefté", "Goes", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @ParameterizedTest
    @CsvSource({
            "100.00, true, 1100.00",
            "200.00, true, 1200.00",
            "325.14, true, 1325.14",
            "489.33, true, 1489.33",
            "1000.00, true, 2000.00"
    })
    public void shouldDepositCorrectAmountFromCsv(double amount, boolean branch, double expected) {
        bankAccount.deposit(amount, branch);
        assertEquals(expected, bankAccount.getBalance(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/deposit-data.csv")
    public void shouldDepositCorrectAmountFromCsvFile(double amount, boolean branch, double expected) {
        bankAccount.deposit(amount, branch);
        assertEquals(expected, bankAccount.getBalance(), 0.01);
    }
}
