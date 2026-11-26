package com.ipl.scenarios;

import com.ipl.model.Match;
import com.ipl.reader.MatchesReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MatchesWonTest {

    static List<Match> matches;

    @BeforeAll
    static void loadMatches() {
        MatchesReader reader = new MatchesReader();
        matches = reader.readFile();
    }

    @Test
    public void testWinsNotEmpty() {
        MatchesWon scenario = new MatchesWon();

        Map<String, Integer> result = scenario.countWins(matches);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testWinCountsArePositive() {
        MatchesWon scenario = new MatchesWon();

        Map<String, Integer> result = scenario.countWins(matches);

        for (int wins : result.values()) {
            assertTrue(wins > 0);
        }
    }

    @Test
    public void testTotalWins() {
        MatchesWon scenario = new MatchesWon();

        Map<String, Integer> result = scenario.countWins(matches);

        long expected = matches.stream()
                .filter(match -> match.getWinner() != null)
                .filter(match -> !match.getWinner().isBlank())
                .count();

        int actual = result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        assertEquals(expected, actual);
    }
}