package com.dexma.challenge.tennis;

import static com.dexma.challenge.tennis.Game.*;

public class AddPointRule implements Rule {

    public GameScore apply(String winner, GameScore currentScore) {
        if (SERVER_WINS.equals(winner)) {
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