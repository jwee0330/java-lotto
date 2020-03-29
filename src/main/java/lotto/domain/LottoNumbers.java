package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private static final int HAS_CONDITION = 1;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(int bonusNumber) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.isMatch(bonusNumber))
                .count() == HAS_CONDITION;
    }

    public int size() {
        return lottoNumbers.size();
    }
}
