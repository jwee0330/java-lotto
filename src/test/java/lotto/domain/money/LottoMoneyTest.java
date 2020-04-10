package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("로또 금액은 1000원 이상어야 한다.")
    @Test
    public void lottoMoneyTest() {
        assertThatThrownBy(() -> LottoMoney.of(999))
                .isInstanceOf(NotEnoughMoneyException.class)
                .hasMessageContaining("구입 금액은 1000원 이상이어야 합니다");
    }

}
