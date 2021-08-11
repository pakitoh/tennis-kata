package com.dexma.challenge.tennis.rules;

import com.dexma.challenge.tennis.GameScore;
import com.dexma.challenge.tennis.Player;
import com.dexma.challenge.tennis.Rule;

import static com.dexma.challenge.tennis.rules.PlayerScore.*;
import static com.dexma.challenge.tennis.Player.SERVER;

public class AddPointRule implements Rule {

    @Override
    public GameScore apply(Player winner, GameScore currentScore) {
        if (winner == SERVER) {
            return new GameScore(
                    next(currentScore.server(), currentScore.receiver()),
                    currentScore.receiver());
        }
        return new GameScore(
                currentScore.server(),
                next(currentScore.receiver(), currentScore.receiver()));
    }

    private String next(String winnerScore, String opponentScore) {
        switch (winnerScore) {
            case ZERO:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FORTY;
            case FORTY:
                if (FORTY.equals(opponentScore) ||
                        ADVANTAGE.equals(opponentScore)) {
                    return ADVANTAGE;
                }
                return WIN;
            case ADVANTAGE:
                return WIN;
        }
        throw new IllegalStateException();
    }
}
