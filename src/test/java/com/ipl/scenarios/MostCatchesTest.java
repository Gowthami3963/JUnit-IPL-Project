
package com.ipl.scenarios;

import com.ipl.model.Delivery;
import com.ipl.reader.DeliveriesReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MostCatchesTest {

    static List<Delivery> deliveries;

    @BeforeAll
    static void loadData() {
        deliveries = new DeliveriesReader().readFile();
    }

    @Test
    public void testCatchesNotEmpty() {
        MostCatches scenario = new MostCatches();

        Map<String, Integer> result =
                scenario.countCatches(deliveries);

        assertFalse(result.isEmpty());
    }

    @Test
    public void testCatchCountsArePositive() {
        MostCatches scenario = new MostCatches();

        Map<String, Integer> result =
                scenario.countCatches(deliveries);

        for (int catches : result.values()) {
            assertTrue(catches > 0);
        }
    }

    @Test
    public void testKnownFielderExists() {
        MostCatches scenario = new MostCatches();

        Map<String, Integer> result =
                scenario.countCatches(deliveries);

        assertTrue(result.containsKey("MS Dhoni"));
    }
}
