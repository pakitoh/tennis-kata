package com.dexma.challenge.tennis;

import static com.dexma.challenge.tennis.Game.ADVANTAGE;

public class DeuceRule implements Rule {

    @Override
    public GameScore apply(String winner, GameScore currentScore) {
        if (isDeuceAgain(currentScore)) {
            return new GameScore(Game.FORTY, Game.FORTY);
        }
        return currentScore;
    }

    private boolean isDeuceAgain(GameScore score) {
        return score.server() == ADVANTAGE &&
                score.receiver() == ADVANTAGE;
    }
}