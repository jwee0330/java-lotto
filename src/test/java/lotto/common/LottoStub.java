package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStub {

    private LottoStub() {
    }

    public static LottoNumbers getLottoNubersOneToSix() {
        return new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    public static LottoNumbers getLottoNubersTwoToSeven() {
        return new LottoNumbers(Arrays.asList(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)));
    }

    public static LottoNumbers getLottoNumbers(int... number) {
        return new LottoNumbers(Arrays.stream(number)
                .mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }


    public static LottoTicket getLottoTicket(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTickets getLottoTickets(LottoTicket... lottoTickets) {
        return new LottoTickets(Arrays.asList(lottoTickets));
    }

    public static LottoTickets getLottoTickets(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

}
