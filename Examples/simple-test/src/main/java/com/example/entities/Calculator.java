package com.example.entities;

public class Calculator {
    public float sumTwoValues(float valueA, float valueB) {
        return valueA + valueB;
    }

    public float divideTwoValues(int valueA, int valueB) {
        return valueA / valueB;
    }

    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
}
