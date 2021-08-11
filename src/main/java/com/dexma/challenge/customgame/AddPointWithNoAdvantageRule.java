package com.dexma.challenge.customgame;

import com.dexma.challenge.tennis.GameScore;
import com.dexma.challenge.tennis.Player;
import com.dexma.challenge.tennis.Rule;

import static com.dexma.challenge.tennis.rules.PlayerScore.*;
import static com.dexma.challenge.tennis.Player.SERVER;

public class AddPointWithNoAdvantageRule implements Rule {

    @Override
    public GameScore apply(Player winner, GameScore currentScore) {
        if (winner == SERVER) {
            return new GameScore(
                    next(currentScore.server()),
                    currentScore.receiver());
        }
        return new GameScore(
                currentScore.server(),
                next(currentScore.receiver()));
    }

    private String next(String currentScore) {
        switch (currentScore) {
            case ZERO:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FORTY;
            case FORTY:
                return WIN;
        }
        throw new IllegalStateException();
    }
}
