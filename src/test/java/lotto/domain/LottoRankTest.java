package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("로또 랭크는 0~6 ")
    @Test
    public void oneTest() {

//        LottoRank.of()
        int matchCount = LottoRank.ONE.getMatchCount();
        int expected = 1;

        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    public void twoTest() {
        int matchCount = LottoRank.TWO.getMatchCount();
        int expected = 1;

        assertThat(matchCount).isEqualTo(expected);
    }

}
