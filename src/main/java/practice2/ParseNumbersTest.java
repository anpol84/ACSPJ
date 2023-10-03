package practice2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static practice2.Client.parseNumbers;

public class ParseNumbersTest {

    @Test
    public void testValidInput() {
        String input = "1.5 -2.3 4";
        double[] expectedOutput = {1.5, -2.3, 4};

        try {
            double[] actualOutput = parseNumbers(input);
            Assertions.assertArrayEquals(expectedOutput, actualOutput);
        } catch (NumberFormatException e) {
            Assertions.fail("Unexpected NumberFormatException: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidInput() {
        String input = "1.5 -2.3 аа";

        try {
            double[] actualOutput = parseNumbers(input);
            Assertions.fail("Expected NumberFormatException, but no exception was thrown");
        } catch (NumberFormatException e) {
            Assertions.assertEquals("Invalid number format in input string", e.getMessage());
        }
    }

    @Test
    public void testInvalidInputSize() {
        String input = "1.5 -2.3";

        try {
            double[] actualOutput = parseNumbers(input);
            Assertions.fail("Expected IllegalArgumentException, but no exception was thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Input string should contain 3 numbers separated by spaces", e.getMessage());
        }
    }

    @Test
    public void testNullInput() {
        String input = null;

        try {
            double[] actualOutput = parseNumbers(input);
            Assertions.fail("Expected NullPointerException, but no exception was thrown");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Input string is null", e.getMessage());
        }
    }
}