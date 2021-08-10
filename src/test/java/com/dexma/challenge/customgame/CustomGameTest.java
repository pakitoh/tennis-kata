package com.dexma.challenge.customgame;

import com.dexma.challenge.tennis.Game;
import com.dexma.challenge.tennis.GameScore;
import com.dexma.challenge.tennis.Rule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.dexma.challenge.tennis.Game.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CustomGameTest {

    @Test
    public void shouldReturn40_WinWhenScoreIs40_40AndReceiverWinsAndRulesWithNoAdvantage() {
        GameScore currentScore = new GameScore(FORTY, FORTY);
        GameScore expectedScore = new GameScore(FORTY, WIN);
        List<Rule> ruleSet = List.of(new AddPointWithNoAdvantageRule());
        Game customGame = new Game(ruleSet);

        GameScore updatedScore = customGame.point(RECEIVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }

    @Test
    public void shouldReturn0_0WhenScoreIs30_40AndServerWinsAndRulesWithNoDeuce() {
        GameScore currentScore = new GameScore(THIRTY, FORTY);
        GameScore expectedScore = new GameScore(ZERO, ZERO);
        List<Rule> ruleSet = List.of(
                new AddPointWithNoAdvantageRule(),
                new NoDeuceRule());
        Game customGame = new Game(ruleSet);

        GameScore updatedScore = customGame.point(SERVER_WINS, currentScore);

        assertThat(updatedScore, equalTo(expectedScore));
    }
}
