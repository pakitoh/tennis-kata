package com.dexma.challenge.tennis;

import java.util.List;

public class Game {
    public static final String SERVER_WINS = "SERVER_WINS";
    public static final String RECEIVER_WINS = "RECEIVER_WINS";
    public static final String ZERO = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";
    public static final String FORTY = "40";
    public static final String ADVANTAGE = "A";
    public static final String WIN = "WIN";

    private final List<Rule> ruleSet = List.of(
            new AddPointRule(),
            new DeuceRule());

    public GameScore point(String winner, GameScore currentScore) {
        return ruleSet
                .stream()
                .reduce(currentScore,
                        (score, rule) -> rule.apply(winner, score),
                        (oldScore, newScore) -> newScore);
    }
}
