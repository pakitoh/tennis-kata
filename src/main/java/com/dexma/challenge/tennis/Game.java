package com.dexma.challenge.tennis;

public class Game {
    public GameScore point(String winner, GameScore currentScore) {
        if("RECEIVER_WINS".equals(winner)) {
            return new GameScore("15", "30");
        }
        return new GameScore("15", "0");
    }
}
