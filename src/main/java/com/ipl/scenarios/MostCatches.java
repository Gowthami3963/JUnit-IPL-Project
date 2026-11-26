
package com.ipl.scenarios;

import com.ipl.model.Delivery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCatches {

    public Map<String, Integer> countCatches(List<Delivery> deliveries) {
        Map<String, Integer> result = new HashMap<>();

        if (deliveries == null) {
            return result;
        }

        for (Delivery delivery : deliveries) {
            if (delivery != null
                    && "caught".equals(delivery.getDismissalKind())
                    && delivery.getFielder() != null
                    && !delivery.getFielder().isBlank()) {

                result.put(delivery.getFielder(),
                        result.getOrDefault(delivery.getFielder(), 0) + 1);
            }
        }

        return result;
    }
}
