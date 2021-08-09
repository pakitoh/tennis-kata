package com.dexma.challenge.tennis;

import static com.dexma.challenge.tennis.Game.*;

public class DeuceRule implements Rule {

    @Override
    public GameScore apply(String winner, GameScore newScore) {
        if (isDeuceAgain(newScore)) {
            return new GameScore(Game.FORTY, Game.FORTY);
        }
        return newScore;
    }

    private boolean isDeuceAgain(GameScore newScore) {
        return newScore.server() == ADVANTAGE &&
                newScore.receiver() == ADVANTAGE;
    }
}