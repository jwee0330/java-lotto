package lotto.domain;

import java.util.Objects;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public LottoRank checkPrize(WinningTicket winningTicket) {
//        int matchCount = (int) lottoTicket.getMatchCountInLottoNumber(winningNumber);
//        if (isMatchFiveAndBonus(winningNumber, matchCount)) {
//            return LottoRank.FIVE_BONUS;
//        }
//        return LottoRank.of(matchCount);
        return LottoRank.ONE;
    }

//    private boolean isMatchFiveAndBonus(WinningNumber winningNumber, int matchCount) {
//        return matchCount == 5 && winningNumber.isMatchBonusNumber(lottoTicket);
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
