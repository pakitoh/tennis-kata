package com.dexma.challenge.tennis;

import com.dexma.challenge.tennis.rules.AddPointRule;
import com.dexma.challenge.tennis.rules.DeuceRule;

import java.util.List;

public class Game {
    private final List<Rule> rules;

    public Game() {
        rules = List.of(
                new AddPointRule(),
                new DeuceRule());
    }

    public Game(List<Rule> rules) {
        this.rules = rules;
    }

    public GameScore point(String winner, GameScore currentScore) {
        return rules
                .stream()
                .reduce(currentScore,
                        (score, rule) -> rule.apply(winner, score),
                        (oldScore, newScore) -> newScore);
    }
}
