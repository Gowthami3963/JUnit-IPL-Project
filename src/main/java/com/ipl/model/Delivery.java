
package com.ipl.model;

public class Delivery {
    private int matchId;
    private String battingTeam;
    private String bowlingTeam;
    private String batsman;
    private String bowler;
    private int totalRuns;
    private int extraRuns;
    private int batsmanRuns;
    private String dismissalKind;
    private String fielder;

    public Delivery(int matchId, String battingTeam, String bowlingTeam,
                    String batsman, String bowler, int totalRuns,
                    int extraRuns, int batsmanRuns,
                    String dismissalKind, String fielder) {

        this.matchId = matchId;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.batsman = batsman;
        this.bowler = bowler;
        this.totalRuns = totalRuns;
        this.extraRuns = extraRuns;
        this.batsmanRuns = batsmanRuns;
        this.dismissalKind = dismissalKind;
        this.fielder = fielder;
    }

    public int getMatchId() {
        return matchId; }

    public String getBattingTeam() {
        return battingTeam; }

    public String getBowlingTeam() {
        return bowlingTeam; }

    public String getBatsman() {
        return batsman; }

    public String getBowler() {
        return bowler; }

    public int getTotalRuns() {
        return totalRuns; }

    public int getExtraRuns() {
        return extraRuns; }

    public int getBatsmanRuns() {
        return batsmanRuns; }

    public String getDismissalKind() {
        return dismissalKind; }

    public String getFielder() {
        return fielder; }
}
