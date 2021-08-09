package com.dexma.challenge.tennis;

import org.junit.jupiter.api.Test;

import static com.dexma.challenge.tennis.Game.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GameTest {

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

    @Test
    public void shouldReturn40_AWhenScoreIs40_40AndReceiverWins() {
        GameScore currentScore = new GameScore(FORTY, FORTY);
        GameScore expectedScore = new GameScore(FORTY, ADVANTAGE);

        GameScore updatedScore = new Game().point(RECEIVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }

    @Test
    public void shouldReturn40_40WhenScoreIs40_AAndReceiverWins() {
        GameScore currentScore = new GameScore(ADVANTAGE, FORTY);
        GameScore expectedScore = new GameScore(FORTY, FORTY);

        GameScore updatedScore = new Game().point(RECEIVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }

    @Test
    public void shouldReturn40_WinWhenScoreIs40_AAndReceiverWins() {
        GameScore currentScore = new GameScore(FORTY, ADVANTAGE);
        GameScore expectedScore = new GameScore(FORTY, WIN);

        GameScore updatedScore = new Game().point(RECEIVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }
}
