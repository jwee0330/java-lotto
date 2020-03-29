package lotto.domain;

import java.util.List;

public class LottoGameMatcher {

    public static int matchCount(LottoTickets lottoTickets, WinningTicket winningTicket) {
        List<LottoRank> lottoRanks = lottoTickets.checkRank(winningTicket);
        return 0;
    }
}
