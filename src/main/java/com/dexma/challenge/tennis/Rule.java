package com.dexma.challenge.tennis;

public interface Rule {
    GameScore apply(Player winner, GameScore newScore);
}
