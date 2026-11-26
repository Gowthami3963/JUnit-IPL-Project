
package com.ipl.scenarios;

import com.ipl.model.Match;
import com.ipl.model.Delivery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtraRuns {

    public Map<String, Integer> calculateExtraRuns(
            List<Match> matches, List<Delivery> deliveries, String season) {

        Map<String, Integer> result = new HashMap<>();

        if (matches == null || deliveries == null || season == null) {
            return result;
        }

        Set<Integer> matchIds = matches.stream()
                .filter(match -> match != null && season.equals(match.getSeason()))
                .map(Match::getId)
                .collect(Collectors.toSet());

        for (Delivery delivery : deliveries) {
            if (delivery != null && matchIds.contains(delivery.getMatchId())
                    && delivery.getBowlingTeam() != null) {

                result.put(delivery.getBowlingTeam(),
                        result.getOrDefault(delivery.getBowlingTeam(), 0)
                                + delivery.getExtraRuns());
            }
        }

        return result;
    }
}
