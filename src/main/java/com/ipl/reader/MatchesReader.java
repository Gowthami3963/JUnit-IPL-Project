
package com.ipl.reader;

import com.ipl.model.Match;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchesReader {

    public List<Match> readFile() {
        List<Match> matches = new ArrayList<>();

        InputStream input = getClass().getClassLoader()
                .getResourceAsStream("data/matches.csv");

        if (input == null) {
            throw new IllegalStateException("matches.csv not found");
        }

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(input))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\t", -1);

                if (values.length < 11 || !values[0].matches("\\d+")) {
                    continue;
                }

                Match match = new Match(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[4],
                        values[5],
                        values[10]
                );

                matches.add(match);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Matches loaded: " + matches.size());
        return matches;
    }
}
