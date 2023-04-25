package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("구입 금액에 해당하는 로또번호(자동)을 발급한다")
    @Test
    void generate() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<LottoTicket> lottoTickets = lottoGenerator.generate(3);
        assertThat(lottoTickets).hasSize(3);
    }
}