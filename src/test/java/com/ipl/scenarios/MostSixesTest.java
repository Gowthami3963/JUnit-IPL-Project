
package com.ipl.scenarios;

import com.ipl.model.Delivery;
import com.ipl.reader.DeliveriesReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MostSixesTest {

    static List<Delivery> deliveries;

    @BeforeAll
    static void loadData() {
        deliveries = new DeliveriesReader().readFile();
    }

    @Test
    public void testSixesNotEmpty() {
        MostSixes scenario = new MostSixes();

        Map<String, Integer> result =
                scenario.countSixes(deliveries);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testSixCountsArePositive() {
        MostSixes scenario = new MostSixes();

        Map<String, Integer> result =
                scenario.countSixes(deliveries);

        for (int sixes : result.values()) {
            assertTrue(sixes > 0);
        }
    }

    @Test
    public void testKnownBatsmanExists() {
        MostSixes scenario = new MostSixes();

        Map<String, Integer> result =
                scenario.countSixes(deliveries);

        assertTrue(result.containsKey("CH Gayle"));
    }
}
