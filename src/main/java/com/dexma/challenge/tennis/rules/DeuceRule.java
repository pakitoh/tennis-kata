package com.dexma.challenge.tennis.rules;

import com.dexma.challenge.tennis.GameScore;
import com.dexma.challenge.tennis.Rule;

import static com.dexma.challenge.tennis.rules.PlayerScore.ADVANTAGE;
import static com.dexma.challenge.tennis.rules.PlayerScore.FORTY;

public class DeuceRule implements Rule {

    @Override
    public GameScore apply(String winner, GameScore currentScore) {
        if (isDeuceAgain(currentScore)) {
            return new GameScore(FORTY, FORTY);
        }
        return currentScore;
    }

    private boolean isDeuceAgain(GameScore score) {
        return score.server() == ADVANTAGE &&
                score.receiver() == ADVANTAGE;
    }
}
