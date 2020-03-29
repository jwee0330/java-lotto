package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;
import lotto.domain.WinningTicket;
import lotto.infrastructure.AutoLottoNumberStrategy;
import lotto.view.InputView;

public class LottoGameController {

    public static void main(String[] args) {

        LottoMoney lottoMoney = new LottoMoney(InputView.requestMoney());
        LottoGame lottoGame = new LottoGame(lottoMoney);

        LottoTickets lottoTickets = lottoGame.buy(new AutoLottoNumberStrategy());

        WinningTicket winningTicket = new WinningTicket(
                InputView.requestWinningNumbers(),
                InputView.requestBonusNumber()
        );
        
//        WinningNumber winningNumber = new WinningNumber(lottoNumber, bonusNumber);
//        LottoGameResults results = lottoGame.getResults(boughtTickets, winningNumber);
//        ResultView.print(results);
    }
}
