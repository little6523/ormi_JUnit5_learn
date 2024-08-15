package pre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    List<Integer> integerList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        integerList.add(10);
    }

    @AfterEach
    void tearDown() {
        integerList.clear();
    }

    @BeforeAll
    static void initAll() {
        System.out.println("테스트 클래스 시작");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("테스트 클래스 종료");
    }

    @Test
    void 간단한_덧셈_테스트() {
        int result = 1 + 1;
        integerList.add(50);
        integerList.add(50);
        integerList.add(50);
        integerList.add(50);
        integerList.add(50);
        System.out.println(integerList.size());
        Assertions.assertEquals(2, result, "1+1 2여야만 합니다.");
    }

    @Test
    void 더하기_테스트() {
        Assertions.assertEquals(integerList.size(), 1);
        //    assertEquals(2, 1 + 1);
    }

    @Disabled("이 테스트는 아직 준비되지 않았습니다.")
    @Test
    void 미완성_테스트() {
        // 테스트 코드
    }

    @Test
    @DisplayName("1 더하기  1은 2와 같아야한다.")
    void 더하기_테스트2() {
        Assertions.assertThat(2).isEqualTo(1+1);
    }
}