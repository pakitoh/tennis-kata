# The Tennis Kata

## Table of Contents

- [Introduction](#Introduction)
- [Goal](#Goal)
- [Development](#development)
  - [Feature1](#Feature1)
  - [Feature2](#Feature2)
- [Build](#Build)
- [Usage](#Usage)


## Introduction

Tennis is a ball and racket sport that is scored in an interesting way. The scoring system of a tennis match is based on points, games and sets. We will focus on the scoring of points inside a
single game for the scope of this exercise, leaving explicitly out the set & match management.
The rules that we want you to consider are the ones found in the section [“Game Score”](https://en.wikipedia.org/wiki/Tennis_scoring_system#Game_score) of the wikipedia page of Tennis Scoring System (excluding the tie-break, which is also out of the scope of this exercise)

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

## Goal

The goal is to provide a library in Java that can be used to score a game in real time, so we can use it for all of the tennis related endeavours we plan to undertake in the future. 
To begin with, we're going to need a way to update the score when a player wins a point, see what the current score is after each service, and see if there is a winner based on the current score and the rules above.

## Development

While developing this library I have tried to follow these principles:
- Keep game score as pure data.
- Lib behaviour is implemented using pure functions. 
- Uses DDD ubiquitous language.
- Developed with TDD.
- Plain Java code.

### Feature1

#### Description

To begin with, we're going to need a way to update the score when a player wins a point, see what the current score is after
each service, and see if there is a winner based on the current score and the rules above.

#### Scenarios

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

#### Notes

I've added a tag FEATURE-1 in git to mark development at this point.

There is a branch in git called FEATURE-1 in case we would like to hotfix this development.

### Feature2

#### Description
Re-design the library to allow that the Tennis rules that you have applied can be dynamically replaced or extended *externally*.

#### Scenarios

<pre>
|-------------------------------------------------|
| Winning Points are Scored Correctly             |
|-------------------------------------------------|
| As a library user with my custom ruleset        |
| I want the winning point to be scored correctly |
| So that I can display the winner                |
|-------------------------------------------------|
| Given the score is 40:40                        |
| When the server wins a point                    |
| Then the server should win                      |
|-------------------------------------------------|
| Given the score is 40:40                        |
| When the receiver wins a point                  |
| Then the receiver should win                    |
|-------------------------------------------------|
</pre>

#### Notes
The mechanism developed is based on the chained application of a list of rules that can be defined when instantiate Game class.

In case one user wants to customize library behaviour, can do this creating their own set of rules implementing `Rule` interface:
```java
public interface Rule {
    GameScore apply(String winner, GameScore newScore);
}
```

Bear in mind that the order in which the rules are incorporated to the list would define the order of application of such rule.

Code developed as part of FEATURE-1 has been refactored as the default set of rules that is used when a `Game` is instantiated using the constructor with no params.

As an example of this customization mechanism, rules described as part of FEATURE-2 has been developed and placed in a different package `com.dexma.challenge.customgame` modeling what a user of the library would do to create their own set of rules.

## Build

Project uses Apache Maven to build so a simple
```bash
mvn clean install
```
would install the JAR file in your local repository.

If you want to include it in your own maven project you can add to your dependencies section: 
```xml
<dependency>
    <groupId>com.dexma.challenge</groupId>
    <artifactId>tennis-kata</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Usage

Unit tests located in `com.dexma.challenge.tennis` and `com.dexma.challenge.customgame` can be explored as examples of use of the library.
