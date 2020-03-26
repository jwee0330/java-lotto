package stringaccumulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAccumulatorTest {

    @DisplayName("표현식을 입력 받아 새로운 StringAccumulator 를 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"", "1,2", "1,2,3", "1,2:3"})
    public void newStringAccumInstanceTest(String expression) {
        StringAccumulator stringAccumulator = new StringAccumulator(expression);

        String takeNewOne = stringAccumulator.getExpression();

        assertThat(takeNewOne).isEqualTo(expression);
    }

    @DisplayName("같은 값으로 생성한 StringAccumulator 인스턴스는 같다")
    @Test
    public void sameCreatedSameExpressionTest() {
        String expression = "1,2";

        assertThat(new StringAccumulator(expression))
                .isEqualTo(new StringAccumulator(expression));
    }
}