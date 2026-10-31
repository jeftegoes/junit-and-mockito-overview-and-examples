package com.example.utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilityParameterizedTest {
    private StringUtility stringUtility;

    @BeforeEach
    public void setup() {
        this.stringUtility = new StringUtility();
    }

    private static Stream<Arguments> removePairsTestConditions() {
        return Stream.of(
                Arguments.of("AABCDDEFF", "ABCDEF"),
                Arguments.of("ABCCABDEEF", "ABCABDEF"),
                Arguments.of("A", "A")
        );
    }

    private static Stream<Arguments> everyNthCharTestConditions() {
        char[] hello = new char[]{'h', 'e', 'l', 'l', 'o'};

        return Stream.of(
                Arguments.of(hello, 2, new char[]{'e', 'l'}),
                Arguments.of(hello, 10, hello)
        );
    }

    @ParameterizedTest
    @MethodSource("everyNthCharTestConditions")
    public void everyNthChar(char[] sourceArray, int n, char[] expected) {
        assertArrayEquals(expected, this.stringUtility.everyNthChar(sourceArray, n));
    }

    @ParameterizedTest
    @MethodSource("removePairsTestConditions")
    public void removePairs(String source, String expected) {
        assertEquals(this.stringUtility.removePairs(source), expected);
    }

    @Test
    public void removePairs() {
        assertNull(this.stringUtility.removePairs(null), "Did not get null returned when argument passed was null.");
    }

    @Test
    public void nullIfOddLength() {
        assertNull(stringUtility.nullIfOddLength("odd"));
        assertNotNull(stringUtility.nullIfOddLength("even"));
    }

    @Test
    public void converter() {
        assertEquals(300, stringUtility.converter(10, 5));
    }

    @Test
    public void converter_ArithmeticException() {
        assertThrows(ArithmeticException.class, () -> {
            stringUtility.converter(10, 0);
        });
    }

    private static Stream<Arguments> truncateAInFirst2PositionsConditions() {
        return Stream.of(
                Arguments.of("AACD", "CD"),
                Arguments.of("CDAA", "CDAA"),
                Arguments.of("ACDB", "CDB")
        );
    }

    @ParameterizedTest
    @MethodSource("truncateAInFirst2PositionsConditions")
    public void truncateAInFirst2Positions(String str, String expected) {
        assertEquals(expected, stringUtility.truncateAInFirst2Positions(str));
    }

    @Test
    public void areFirstAndLasTwoCharactersTheSame() {
        assertFalse(stringUtility.areFirstAndLasTwoCharactersTheSame("ABCD"));
        assertTrue(stringUtility.areFirstAndLasTwoCharactersTheSame("ABAB"));
        assertTrue(stringUtility.areFirstAndLasTwoCharactersTheSame("AB"));
        assertFalse(stringUtility.areFirstAndLasTwoCharactersTheSame("A"));
    }
}
