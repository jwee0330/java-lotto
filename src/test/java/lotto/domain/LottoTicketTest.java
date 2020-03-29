package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("로또 번호로 로또 번호들을 만들 수 있다.")
    @Test
    public void newLottoNumberInstanceTest() {
        LottoNumber one = new LottoNumber(1);
        LottoNumber another = new LottoNumber(1);

    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다.")
    @Test
    public void returnMatchedNumberCountTest() {


    }

}
