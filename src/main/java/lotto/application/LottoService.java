package lotto.application;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.infra.AutoLottoNumberStrategy;
import lotto.domain.machine.infra.ManualLottoNumberStrategy;
import lotto.domain.money.LottoMoney;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.rank.WinningLotto;

import java.util.List;

public class LottoService {
    private static final int ZERO = 0;

    private final LottoMachine lottoMachine;
    private final int availableCount;

    public LottoService(LottoMachine lottoMachine, LottoMoney lottoMoney) {
        this.lottoMachine = lottoMachine;
        this.availableCount = lottoMoney.getAvailableBuyingCount(ZERO);
    }

    public List<Lotto> buyManual(Lotteries lotteries) {
        Lotteries manualLotteries = lottoMachine.buy(new ManualLottoNumberStrategy(lotteries));
        return manualLotteries.getLotteries();
    }

    public List<Lotto> buyAuto(int buyCount) {
        Lotteries autoLotteries = lottoMachine.buy(new AutoLottoNumberStrategy(buyCount));
        return autoLotteries.getLotteries();
    }

    public int pay(int boughtCount) {
        if (availableCount < boughtCount) {
            throw new IllegalArgumentException("이용가능한 양보다 더 많이 구매할 수 없습니다.");
        }
        return availableCount - boughtCount;
    }

    public LottoRanks matchResults(Lotteries lotteries, WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = winningLotto.matchLotteries(lotteries.getLotteries());
        return LottoRanks.of(lottoRanks);
    }
}
