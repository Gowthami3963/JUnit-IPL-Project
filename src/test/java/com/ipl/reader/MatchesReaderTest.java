package com.ipl.reader;

import com.ipl.model.Match;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MatchesReaderTest {

    @Test
    public void testReadMatches() {

        MatchesReader reader = new MatchesReader();

        List<Match> matches = reader.readFile();

        assertFalse(matches.isEmpty());
        assertEquals(636, matches.size());
    }
}