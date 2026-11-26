
package com.ipl.scenarios;

import com.ipl.model.Match;
import com.ipl.model.Delivery;
import com.ipl.reader.MatchesReader;
import com.ipl.reader.DeliveriesReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ExtraRunsTest {

    static List<Match> matches;
    static List<Delivery> deliveries;

    @BeforeAll
    static void loadData() {
        matches = new MatchesReader().readFile();
        deliveries = new DeliveriesReader().readFile();
    }

    @Test
    public void testExtraRunsNotEmpty() {
        ExtraRuns scenario = new ExtraRuns();

        Map<String, Integer> result =
                scenario.calculateExtraRuns(matches, deliveries, "2016");

        assertFalse(result.isEmpty());
    }

    @Test
    public void testExtraRunsArePositive() {
        ExtraRuns scenario = new ExtraRuns();

        Map<String, Integer> result =
                scenario.calculateExtraRuns(matches, deliveries, "2016");

        for (int runs : result.values()) {
            assertTrue(runs > 0);
        }
    }

    @Test
    public void testTotalExtraRuns() {
        ExtraRuns scenario = new ExtraRuns();

        Map<String, Integer> result =
                scenario.calculateExtraRuns(matches, deliveries, "2016");

        int actual = result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        int expected = deliveries.stream()
                .filter(d -> d.getMatchId() > 0)
                .filter(d -> matches.stream().anyMatch(m ->
                        m.getId() == d.getMatchId()
                                && m.getSeason().equals("2016")))
                .mapToInt(Delivery::getExtraRuns)
                .sum();

        assertEquals(expected, actual);
    }
}
