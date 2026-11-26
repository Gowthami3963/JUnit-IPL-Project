
package com.ipl.scenarios;

import com.ipl.model.Delivery;
import com.ipl.reader.DeliveriesReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BowlerEconomyTest {

    static List<Delivery> deliveries;

    @BeforeAll
    static void loadData() {
        deliveries = new DeliveriesReader().readFile();
    }

    @Test
    public void testEconomyNotEmpty() {
        BowlerEconomy scenario = new BowlerEconomy();

        Map<String, Double> result =
                scenario.calculateEconomy(deliveries);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testEconomyIsPositive() {
        BowlerEconomy scenario = new BowlerEconomy();

        Map<String, Double> result =
                scenario.calculateEconomy(deliveries);

        for (double economy : result.values()) {
            assertTrue(economy >= 0);
        }
    }

    @Test
    public void testEconomyContainsKnownBowler() {
        BowlerEconomy scenario = new BowlerEconomy();

        Map<String, Double> result =
                scenario.calculateEconomy(deliveries);

        assertTrue(result.containsKey("TS Mills"));
    }
}
