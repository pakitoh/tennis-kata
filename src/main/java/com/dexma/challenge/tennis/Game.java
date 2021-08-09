package com.dexma.challenge.tennis;

public class Game {
    public static final String SERVER_WINS = "SERVER_WINS";
    public static final String RECEIVER_WINS = "RECEIVER_WINS";
    public static final String ZERO = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";
    public static final String FORTY = "40";
    public static final String ADVANTAGE = "A";
    public static final String WIN = "WIN";

    public GameScore point(String winner, GameScore currentScore) {
        GameScore newScore = addPoint(winner, currentScore);
        if (isDeuceAgain(newScore)) {
            return new GameScore(FORTY, FORTY);
        }
        return newScore;
    }

    private GameScore addPoint(String winner, GameScore currentScore) {
        if (SERVER_WINS.equals(winner)) {
            return new GameScore(
                    next(currentScore.server(), currentScore.receiver()),
                    currentScore.receiver());
        }
        return new GameScore(
                currentScore.server(),
                next(currentScore.receiver(), currentScore.receiver()));
    }

    private String next(String currentScore, String opponentScore) {
        switch (currentScore) {
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

    private boolean isDeuceAgain(GameScore newScore) {
        return newScore.server() == ADVANTAGE &&
                newScore.receiver() == ADVANTAGE;
    }
}
