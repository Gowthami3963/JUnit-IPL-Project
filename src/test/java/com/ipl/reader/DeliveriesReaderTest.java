package com.ipl.reader;

import com.ipl.model.Delivery;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeliveriesReaderTest {

    @Test
    public void testReadDeliveries() {

        DeliveriesReader reader = new DeliveriesReader();

        List<Delivery> deliveries = reader.readFile();

        assertFalse(deliveries.isEmpty());
        assertEquals(150460, deliveries.size());
    }
}