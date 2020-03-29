package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 구매할수 있는 게임 회수를 알 수 있다. (1000원=1게임)")
    @ParameterizedTest
    @CsvSource(value = {"3000, 3", "10000, 10"})
    public void buyLottoTest(int moneyAmount, int expectedGameCount) {

    }

    @DisplayName("구입 금액은 1000원 이상이어야 한다.")
    @Test
    public void depositGraterThanThousand() {
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다. (1000원=1게임)")
    @ParameterizedTest
    @CsvSource(value = {"3000, 3", "10000, 10"})
    public void buyLottoGameTest(int money, int expectedGameCount) {
    }

}
