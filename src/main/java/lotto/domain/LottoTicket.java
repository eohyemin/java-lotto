package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_TICKET_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        return new LottoTicket(lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 티켓은 6개의 로또 번호로만 구성됩니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> noDuplicatedNumbers = new HashSet<>(lottoNumbers);
        if(noDuplicatedNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복이 허용되지 않습니다.");
        }
    }
}
