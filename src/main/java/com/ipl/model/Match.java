
package com.ipl.model;

public class Match {

    private int id;
    private String season;
    private String team1;
    private String team2;
    private String winner;

    public Match(int id, String season, String team1, String team2, String winner) {
        this.id = id;
        this.season = season;
        this.team1 = team1;
        this.team2 = team2;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getWinner() {
        return winner;
    }
}
