# The Tennis Kata

## Introduction
Tennis is a ball and racket sport that is scored in an interesting way. The scoring system of a tennis match is based on points, games and sets. We will focus on the scoring of points inside a
single game for the scope of this exercise, leaving explicitly out the set & match management.
The rules that we want you to consider are the ones found in the section “Game Score” of the wikipedia page of Tennis Scoring System (excluding the tie-break, which is also out of the scope of this exercise)

### Tennis Scoring System

A game consists of a sequence of points played with the same player serving, and is won by the first side to have won at least four points with a margin of two points or more over their opponent. Normally the server's score is always called first and the receiver's score second. Score calling in tennis is unusual in that (except in tie-breaks) each point has a corresponding call that is different from its point value. The current point score is announced orally before each point by the umpire, or by the server if there is no umpire.

<pre>
|----------------------|--------------------|
| Number of points won | Corresponding call |
|----------------------|--------------------|
| 0                    | "love"             |
| 1                    | "15"               |
| 2                    | "30"               |
| 3                    | "40"               |
| 4                    | "game"             |
|----------------------|--------------------|
</pre>

For instance, if the server has won three points so far in the game, and the non-server has won one, the score is "40–15".
When both sides have won the same number of points within a given game—i.e., when each side has won one, or two, points—the score is described as "15 all" and "30 all", respectively. However, if each player has won three points, the score is called as "deuce", not "40 all". From that point on in the game, whenever the score is tied, it is described as "deuce" regardless of how many points have been played.
However, if the score is called in French, for example at the French Open, the first occurrence of "40 all" in a single game may be called as such ("40-A", "Quarante-A", or "Quarante partout"). Thereafter, "deuce" ("Égalité" in French) is used for all other occurrences when the score returns to "40 all" within the same game.
In standard play, scoring beyond a "deuce" score, in which the players have scored three points each, requires that one player must get two points ahead in order to win the game. This type of tennis scoring is known as "advantage scoring" (or "ads"). The side which wins the next point after deuce is said to have the advantage. If they lose the next point, the score is again deuce, since the score is tied. If the side with the advantage wins the next point, that side has won the game, since they have a lead of two points. When the server is the player with the advantage, the score may be called as "advantage in". When the server's opponent has the advantage, the score may be called as "advantage out". These phrases are sometimes shortened to "ad in" or "van in" (or "my ad") and "ad out" (or "your ad"). Alternatively, the players' names are used: in professional tournaments the umpire announces the score in this format (e.g., "advantage Nadal" or "advantage Williams").
In the USTA rule book (but not the ITF rules), there is the following comment: "'Zero,' 'one,' 'two,' and 'three,' may be substituted for 'Love', '15', '30', and '40.' This is particularly appropriate for matches with an inexperienced player or in which one player does not understand English." 

## Scenarios 

<pre>
|---------------------------------------------------------|
| Winning a Point Increases Score Correctly               |
|---------------------------------------------------------|
| As a library user                                       |
| I want the score to increase when a player wins a point |
| So that I can display the current score correctly       |
|---------------------------------------------------------|
| Given the score is 0:0                                  |
| When the server wins a point                            |
| Then the score is 15:0                                  |
|---------------------------------------------------------|
| Given the score is 15:15                                |
| When the receiver wins a point                          |
| Then the score is 15:30                                 |
|---------------------------------------------------------|
| Given the score is 30:30                                |
| When the server wins a point                            |
| Then the score is 40:30                                 |
|---------------------------------------------------------|
</pre>

<pre>
|---------------------------------------------------------|
| Deuce and Advantage are Scored Correctly                |
|---------------------------------------------------------|
| As a library user                                       |
| I want deuce and advantage to be scored correctly       |
| So that I can display the current score correctly       |
|---------------------------------------------------------|
| Given the score is 40:40                                |
| When the receiver wins a point                          |
| Then the score should be 40:A                           |
|---------------------------------------------------------|
| Given the score is A:40                                 |
| When the receiver wins a point                          |
| Then the score should be 40:40                          |
|---------------------------------------------------------|
</pre>

<pre>
|---------------------------------------------------------|
| Winning Points are Scored Correctly                     |
|---------------------------------------------------------|
| As a library user                                       |
| I want the winning point to be scored correctly         |
| So that I can display the winner                        |
|---------------------------------------------------------|
| Given the score is 40:30                                |
| When the server wins a point                            |
| Then the server should win                              |
|---------------------------------------------------------|
| Given the score is 40:A                                 |
| When the receiver wins a point                          |
| Then the receiver should win                            |
|---------------------------------------------------------|
</pre>

