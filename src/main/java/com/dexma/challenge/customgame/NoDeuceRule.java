package com.dexma.challenge.customgame;

import com.dexma.challenge.tennis.GameScore;
import com.dexma.challenge.tennis.Player;
import com.dexma.challenge.tennis.Rule;

import static com.dexma.challenge.tennis.rules.PlayerScore.FORTY;
import static com.dexma.challenge.tennis.rules.PlayerScore.ZERO;

public class NoDeuceRule implements Rule {

    @Override
    public GameScore apply(Player winner, GameScore currentScore) {
        if (FORTY.equals(currentScore.server()) &&
                FORTY.equals(currentScore.receiver())) {
            return new GameScore(ZERO, ZERO);
        }
        return currentScore;
    }
}
