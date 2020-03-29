package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constant.PRICE_PER_GAME;

public class LottoGameResults {
    private static final double ZERO = 0;
    private static final int LOTTO_WIN_MIN = 3;
    private static final int LOTTO_WIN_MAX = 6;
    private static final int LOTTO_WIN_BONUS = 51;

    private final List<LottoRank> lottoRanks;

    LottoGameResults(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<LottoRank> getWinningGames() {
        return new ArrayList<>(lottoRanks);
    }

    public double getProfitRate() {
        return getWinningPrizeSum() / (double) (lottoRanks.size() * PRICE_PER_GAME);
    }

    public long getMatchCount(int matchCount) {
        return lottoRanks.stream()
                .filter(lottoRank -> isMatch(lottoRank.getMatchCount(), matchCount))
                .count();
    }

    double getWinningPrizeSum() {
        double winningPrizeSum = ZERO;
        for (int i = LOTTO_WIN_MIN; i <= LOTTO_WIN_MAX; i++) {
            long count = getMatchCount(i);
            winningPrizeSum += (count * LottoRank.of(i).getWinningPrize());
        }
        return getFiveBonusPrize(winningPrizeSum);
    }

    private double getFiveBonusPrize(double winningPrizeSum) {
        long fiveBonusCount = getMatchCount(LOTTO_WIN_BONUS);
        winningPrizeSum += (fiveBonusCount * LottoRank.of(LOTTO_WIN_BONUS).getWinningPrize());
        return winningPrizeSum;
    }

    private boolean isMatch(int matchCount, int checkPoint) {
        return matchCount == checkPoint;
    }

}
