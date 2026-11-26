
package com.ipl.scenarios;

import com.ipl.model.Match;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesWon {

    public Map<String, Integer> countWins(List<Match> matches) {
        Map<String, Integer> result = new HashMap<>();

        if (matches == null) {
            return result;
        }

        for (Match match : matches) {
            if (match != null && match.getWinner() != null
                    && !match.getWinner().isBlank()) {
                result.put(match.getWinner(),
                        result.getOrDefault(match.getWinner(), 0) + 1);
            }
        }

        return result;
    }
}
