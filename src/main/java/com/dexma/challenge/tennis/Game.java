package com.dexma.challenge.tennis;

public class Game {
    public GameScore point(String winner, GameScore currentScore) {
        if("RECEIVER_WINS".equals(winner)) {
            return new GameScore(currentScore.server(), next(currentScore.receiver()));
        }
        return new GameScore(next(currentScore.server()), currentScore.receiver());
    }

    private String next(String currentScore) {
        switch (currentScore) {
            case "0":
                return "15";
            case "15":
                return "30";
            case "30":
                return "40";
        }
        throw new IllegalStateException();
    }


}
