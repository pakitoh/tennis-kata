package com.dexma.challenge.tennis;

public class Game {
    public static final String SERVER_WINS = "SERVER_WINS";
    public static final String RECEIVER_WINS = "RECEIVER_WINS";
    public static final String ZERO = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";
    public static final String FORTY = "40";
    public static final String ADVANTAGE = "A";

    public GameScore point(String winner, GameScore currentScore) {
        GameScore newScore = calculate(winner, currentScore);
        if(newScore.server() == ADVANTAGE && newScore.receiver() == ADVANTAGE) {
            return new GameScore(FORTY, FORTY);
        }
        return newScore;
    }

    private GameScore calculate(String winner, GameScore currentScore) {
        if ("RECEIVER_WINS".equals(winner)) {
            return new GameScore(currentScore.server(), next(currentScore.receiver()));
        }
        return new GameScore(next(currentScore.server()), currentScore.receiver());
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
                return ADVANTAGE;
        }
        throw new IllegalStateException();
    }
}
