package pre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("두 양수의 합")
    @Test
    void testAddTwoPositiveNumbers() {
        int result = calculator.addTwoInteger(3, 4);
        Assertions.assertEquals(7, result, "3+4 should equal 7");
    }

    @DisplayName("두 음수의 합")
    @Test
    void testTwoNegativeNumbers() {
        int result = calculator.addTwoInteger(3, -4);
        Assertions.assertEquals(-1, result, "-1 필요");
    }

    @DisplayName("양수와 음수의 합")
    @Test
    void testAddPositiveAndNegativeNumber() {
        int result = calculator.addTwoInteger(3, -4);
        Assertions.assertEquals(-1, result, "3 + (-4) should equal -1");
    }

    @DisplayName("0 더하기")
    @Test
    void testAddZero() {
        int result = calculator.addTwoInteger(3, 0);
        Assertions.assertEquals(3, result, "3 + 0 should equal 3");
    }

    @DisplayName("오버플로가 발생하는 덧셈")
    @Test
    void testAddWithOverflow() {
        assertEquals(Integer.MIN_VALUE, calculator.addTwoInteger(Integer.MAX_VALUE, 1),
                "Adding 1 to MAX_VALUE should result in MIN_VALUE due to overflow");
    }
}