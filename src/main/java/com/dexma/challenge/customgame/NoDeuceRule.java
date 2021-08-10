package com.dexma.challenge.customgame;

import com.dexma.challenge.tennis.Game;
import com.dexma.challenge.tennis.GameScore;
import com.dexma.challenge.tennis.Rule;

import static com.dexma.challenge.tennis.Game.FORTY;

public class NoDeuceRule implements Rule {

    @Override
    public GameScore apply(String winner, GameScore currentScore) {
        if (FORTY.equals(currentScore.server()) &&
                FORTY.equals(currentScore.receiver())) {
            return new GameScore(Game.ZERO, Game.ZERO);
        }
        return currentScore;
    }
}