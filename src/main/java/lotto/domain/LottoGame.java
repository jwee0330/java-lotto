package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final LottoMoney lottoMoney;

    public LottoGame(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public LottoTickets buy(LottoNumberStrategy lottoNumberStrategy) {
        int availableCount = lottoMoney.getAvailableBuyingCount();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < availableCount; i++) {
            lottoTickets.add(lottoNumberStrategy.get());
        }
        return new LottoTickets(lottoTickets);
    }

    public LottoGameResults getResults(LottoTickets lottoTickets, WinningTicket winningTicket) {
        return new LottoGameResults(lottoTickets.checkRank(winningTicket));
    }

    private int calculateAutoGameCount(LottoMoney lottoMoney) {
        return lottoMoney.getAvailableBuyingCount();
    }

}
