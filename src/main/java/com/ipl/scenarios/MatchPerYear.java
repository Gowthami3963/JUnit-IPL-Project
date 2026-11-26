package com.ipl.scenarios;

import com.ipl.model.Match;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchPerYear {

    public Map<String, Integer> countMatches(List<Match> matches) {
        Map<String, Integer> result = new HashMap<>();

        if (matches == null) {
            return result;
        }

        for (Match match : matches) {
            if (match != null && match.getSeason() != null) {
                result.put(match.getSeason(),
                        result.getOrDefault(match.getSeason(), 0) + 1);
            }
        }

        return result;
    }
}