package com.dexma.challenge.tennis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameTest {

    public static final String SERVER_WINS = "SERVER_WINS";
    public static final String ZERO = "0";
    public static final String FIFTEEN = "15";

    @Test
    public void shouldReturn15_0WhenScoreIs0_0AndServerWins() {
        GameScore currentScore = new GameScore(ZERO, ZERO);
        GameScore expectedScore = new GameScore(FIFTEEN, ZERO);

        GameScore updatedScore = new Game().point(SERVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }
}
