package com.ipl.scenarios;

import com.ipl.model.Match;
import com.ipl.reader.MatchesReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MatchPerYearTest {

    static List<Match> matches;

    @BeforeAll
    static void loadMatches() {
        MatchesReader reader = new MatchesReader();
        matches = reader.readFile();
    }

    @Test
    public void testMatchesPerYearNotEmpty() {
        MatchPerYear scenario = new MatchPerYear();

        Map<String, Integer> result = scenario.countMatches(matches);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testTotalMatchesCount() {
        MatchPerYear scenario = new MatchPerYear();

        Map<String, Integer> result = scenario.countMatches(matches);

        int total = result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        assertEquals(636, total);
    }

    @Test
    public void testMatchesIn2017() {
        MatchPerYear scenario = new MatchPerYear();

        Map<String, Integer> result = scenario.countMatches(matches);

        assertEquals(59, result.get("2017"));
    }
}