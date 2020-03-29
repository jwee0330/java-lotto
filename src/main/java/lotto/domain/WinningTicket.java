package lotto.domain;

public class WinningTicket {
    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningTicket(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new BonusNumber(lottoNumbers, bonusNumber);
    }

    public boolean isMatchBonusNumber(LottoNumber winningNumber) {
//        return winningNumber.getLottoNumber()
//                .stream()
//                .filter(this::isMatchBonusNumber)
//                .count() == 1;
        return true;
    }

    private boolean isMatchBonusNumber(int number) {
        return bonusNumber.equals(number);
    }

    public int matchCountFrom(LottoTicket lottoTicket) {
//        this.lottoTicket.compare(lottoTicket);
        return 0;
    }
}
