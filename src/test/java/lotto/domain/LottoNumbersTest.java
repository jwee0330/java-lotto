package lotto.domain;

import lotto.common.LottoStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("6개의 로또 번호를 가진 로또 번호들을 만들 수 있다")
    @Test
    public void lottoNumbersCreateTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호들은 번호가 6개 이어야만 한다")
    @Test
    public void lottoNumbersSizeTest() {
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = LottoStub.getLottoNumbers(1, 2, 3, 4, 5);
            lottoNumbers.size();
        }).isInstanceOf(LottoNumbersSizeException.class)
                .hasMessageContaining("로또 번호는 6개 이어야만 합니다.");
    }

    @DisplayName("로또 번호들중에 입력받은 번호가 존재하는지 확인할 수 있다")
    @ParameterizedTest
    @CsvSource(value = "1 : true, 6 : true, 7 : false", delimiter = ',')
    public void lottoNumbersContainsTest(String source) {
        String[] split = source.split(" : ");
        int number = Integer.parseInt(split[0]);
        boolean expected = Boolean.parseBoolean(split[1]);

        LottoNumbers lottoNumbers = LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6);
        boolean contains = lottoNumbers.contains(number);

        assertThat(contains).isEqualTo(expected);
    }
}