package com.dexma.challenge.tennis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameTest {

    public static final String SERVER_WINS = "SERVER_WINS";
    public static final String RECEIVER_WINS = "RECEIVER_WINS";
    public static final String ZERO = "0";
    public static final String FIFTEEN = "15";
    public static final String THIRTY = "30";
    public static final String FORTY = "40";

    @Test
    public void shouldReturn15_0WhenScoreIs0_0AndServerWins() {
        GameScore currentScore = new GameScore(ZERO, ZERO);
        GameScore expectedScore = new GameScore(FIFTEEN, ZERO);

        GameScore updatedScore = new Game().point(SERVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }

    @Test
    public void shouldReturn15_30WhenScoreIs15_15AndReceiverWins() {
        GameScore currentScore = new GameScore(FIFTEEN, FIFTEEN);
        GameScore expectedScore = new GameScore(FIFTEEN, THIRTY);

        GameScore updatedScore = new Game().point(RECEIVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }

    @Test
    public void shouldReturn40_30WhenScoreIs30_30AndServerWins() {
        GameScore currentScore = new GameScore(THIRTY, THIRTY);
        GameScore expectedScore = new GameScore(FORTY, THIRTY);

        GameScore updatedScore = new Game().point(SERVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }
}
