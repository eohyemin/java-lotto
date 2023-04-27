package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoPrize {
    RANK1(6, 2_000_000_000),
    RANK2(5, 1_500_000),
    RANK3(4, 50_000),
    RANK4(3, 5_000),
    LOST(0, 0);

    private static final Map<Integer, LottoPrize> BY_LOTTO_PRIZE = new HashMap<>();

    static {
        for (LottoPrize rank : values()) {
            BY_LOTTO_PRIZE.put(rank.rankCount, rank);
        }
    }

    private final int rankCount;
    private final int money;

    LottoPrize(int rankCount, int money) {
        this.rankCount = rankCount;
        this.money = money;
    }

    public static LottoPrize getWinningPrize(int matchCount) {
        if(!BY_LOTTO_PRIZE.containsKey(matchCount)) {
            return LottoPrize.LOST;
        }
        return BY_LOTTO_PRIZE.get(matchCount);
    }

    public static Map<LottoPrize, Integer> makeLottoResult() {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize != LOST)
                .collect(Collectors.toMap(Function.identity(), o -> 0));
    }

    public int money() {
        return this.money;
    }

    public int rankCount() {
        return this.rankCount;
    }
}
