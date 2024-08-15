package pre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ormispring.tdddemo.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setUpAll() {
        System.out.println("테스트 시작!");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("각 테스트 시작 전 실행");
    }

    @Test
    @DisplayName("1 더하기 1은 2여야 한다.")
    void testAddition() {
        Assertions.assertThat(2).isEqualTo(calculator.add(1, 1));
    }

    @Test
    @DisplayName("5 빼기 3은 2여야 한다")
    void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
    }

    @Test
    @Disabled("곱하기 기능은 아직 구현되지 않았습니다")
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - 각 테스트 종료 후 실행");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - 모든 테스트 종료 후 1번 실행");
    }
}