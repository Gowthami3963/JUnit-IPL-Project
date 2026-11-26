
package com.ipl.scenarios;

import com.ipl.model.Delivery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostSixes {

    public Map<String, Integer> countSixes(List<Delivery> deliveries) {
        Map<String, Integer> result = new HashMap<>();

        if (deliveries == null) {
            return result;
        }

        for (Delivery delivery : deliveries) {
            if (delivery != null && delivery.getBatsman() != null
                    && delivery.getBatsmanRuns() == 6) {
                result.put(delivery.getBatsman(),
                        result.getOrDefault(delivery.getBatsman(), 0) + 1);
            }
        }

        return result;
    }
}

