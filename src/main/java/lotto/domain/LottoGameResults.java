package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoGameResults {
    private static final int LOTTO_WIN_MIN = 3;
    private static final int LOTTO_WIN_MAX = 6;

    private final int totalGameCount;
    private final List<LottoRank> winningGames;

    LottoGameResults(int totalGameCount, List<LottoRank> winningGames) {
        this.totalGameCount = totalGameCount;
        this.winningGames = winningGames;
    }

    public List<LottoRank> getWinningGames() {
        return new ArrayList<>(winningGames);
    }

    public double getProfitRate() {
        return getWinningPrizeSum() / (double) (totalGameCount * DEFAULT_GAME_PRICE);
    }

    public long getMatchCount(int index) {
        return winningGames.stream()
                .filter(ticketRank -> isMatch(ticketRank.getMatchCount(), index))
                .count();
    }

    double getWinningPrizeSum() {
        double winningPrizeSum = 0;
        for (int i = LOTTO_WIN_MIN; i <= LOTTO_WIN_MAX; i++) {
            long count = getMatchCount(i);
            winningPrizeSum += (count * LottoRank.of(i).getWinningPrize());
        }
        return winningPrizeSum;
    }

    private boolean isMatch(int matchCount, int checkPoint) {
        return matchCount == checkPoint;
    }
}
