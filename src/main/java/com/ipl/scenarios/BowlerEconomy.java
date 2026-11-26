
package com.ipl.scenarios;

import com.ipl.model.Delivery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BowlerEconomy {

    public Map<String, Double> calculateEconomy(List<Delivery> deliveries) {
        Map<String, Integer> runs = new HashMap<>();
        Map<String, Integer> balls = new HashMap<>();
        Map<String, Double> result = new HashMap<>();

        if (deliveries == null) {
            return result;
        }

        for (Delivery delivery : deliveries) {
            if (delivery == null || delivery.getBowler() == null) {
                continue;
            }

            String bowler = delivery.getBowler();

            runs.put(bowler, runs.getOrDefault(bowler, 0)
                    + delivery.getTotalRuns());

            if (delivery.getExtraRuns() == 0) {
                balls.put(bowler, balls.getOrDefault(bowler, 0) + 1);
            }
        }

        for (String bowler : runs.keySet()) {
            int legalBalls = balls.getOrDefault(bowler, 0);

            if (legalBalls > 0) {
                result.put(bowler,
                        (runs.get(bowler) * 6.0) / legalBalls);
            }
        }

        return result;
    }
}
