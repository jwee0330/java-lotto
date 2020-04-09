package lotto.ui;

import lotto.application.*;
import lotto.domain.lotto.Lottery;
import lotto.domain.rank.LottoRanks;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoBuyResponse buy(LottoRequest lottoRequest) {
        ManualLottery manualLottery =
                lottoService.buyManual(lottoRequest.getLottoMoney(), lottoRequest.getLottoNumbers());

        Lottery lotteryByManual = manualLottery.getLottery();
        Lottery lotteryByAuto = lottoService.buyAuto(manualLottery.getLottoMoney());

        return DtoAssembler.assembleLottoByResponse(lotteryByManual, lotteryByAuto);
    }

    public LottoRanks match(Lottery lottery, WinningLottoRequest winningLottoDto) {
        return lottoService.match(lottery, winningLottoDto);
    }
}