package lotto.application;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.money.LottoMoney;
import lotto.domain.money.NotAffordableMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    @DisplayName("수동 구매 테스트")
    @Test
    public void buyManualTest() {
        LottoService lottoService = new LottoService(new LottoMachine(), LottoMoney.of(5000), availableCount);

        List<Integer> lottoManualNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotteries lotteries = Lotteries.of(Arrays.asList(lottoManualNumbers));
        List<Lotto> lotteriesByManual = lottoService.buyManual(lotteries);

        assertThat(lotteriesByManual).isEqualTo(lotteries.getLotteries());
    }

    @DisplayName("자동 구매 테스트")
    @Test
    public void buyAutoTest() {
        LottoService lottoService = new LottoService(new LottoMachine(), LottoMoney.of(5000), availableCount);
        List<Lotto> lotteriesByAuto = lottoService.buyAuto(LottoMoney.of(5000));

        assertThat(lotteriesByAuto).hasSize(5);
    }

    @DisplayName("로또 머니 지불 테스트 : 입력한 금액을 초과하여 구매할 수 없다")
    @Test
    public void payOverTest() {
        LottoService lottoService = new LottoService(new LottoMachine(), LottoMoney.of(5000), availableCount);

        assertThatThrownBy(() -> lottoService.pay(10))
                .isInstanceOf(NotAffordableMoneyException.class)
                .hasMessageContaining("입력한 금액을 초과하여 구매할 수 없습니다.");
    }

    @DisplayName("로또 머니 지불 테스트")
    @Test
    public void payTest() {
        LottoService lottoService = new LottoService(new LottoMachine(), LottoMoney.of(5000), availableCount);

        LottoMoney remainsMoney = lottoService.pay(5);
        int availableBuyingCount = remainsMoney.getAvailableBuyingCount();

        assertThat(availableBuyingCount).isEqualTo(0);
    }



}
