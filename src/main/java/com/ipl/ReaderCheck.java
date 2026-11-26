package com.ipl;

import com.ipl.reader.MatchesReader;
import com.ipl.reader.DeliveriesReader;
import com.ipl.model.Match;
import com.ipl.model.Delivery;

import java.util.List;

public class ReaderCheck {

    public static void main(String[] args) {

        MatchesReader matchesReader = new MatchesReader();
        DeliveriesReader deliveriesReader = new DeliveriesReader();

        List<Match> matches = matchesReader.readFile();
        List<Delivery> deliveries = deliveriesReader.readFile();

        System.out.println("Total matches: " + matches.size());
        System.out.println("Total deliveries: " + deliveries.size());
    }
}