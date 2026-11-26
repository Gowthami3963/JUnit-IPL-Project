
package com.ipl.reader;

import com.ipl.model.Delivery;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveriesReader {

    public List<Delivery> readFile() {
        List<Delivery> deliveries = new ArrayList<>();

        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("data/deliveries.csv");

        if (input == null) {
            throw new IllegalStateException("deliveries.csv not found");
        }

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(input))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",", -1);

                if (values.length != 21) {
                    continue;
                }

                Delivery delivery = new Delivery(
                        Integer.parseInt(values[0]),
                        values[2],
                        values[3],
                        values[6],
                        values[8],
                        Integer.parseInt(values[17]),
                        Integer.parseInt(values[16]),
                        Integer.parseInt(values[15]),
                        values[19],
                        values[20]
                );

                deliveries.add(delivery);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return deliveries;
    }
}
