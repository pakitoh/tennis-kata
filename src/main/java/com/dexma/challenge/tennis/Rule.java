package com.dexma.challenge.tennis;

public interface Rule {
    GameScore apply(String winner, GameScore newScore);
}
