package com.frc1699.match;

import java.util.Map;

public class Match {

    String key;
    String comp_level;
    int set_number;
    int match_number;
    Map<String, Alliance> alliances;

    String winning_alliance;
    String event_key;
    long time;
    long actual_time;
    long post_result_time;
    long predicted_time;
    Map<String, MatchResults> score_breakdown;
    Video[] videos;

    @Override
    public String toString() {
        return "" + actual_time + alliances;
    }

    public int computeScore(String alliance) {
        if(!(alliance.equals("red") || alliance.equals("blue"))){
            throw new IllegalArgumentException("Invalid Alliance Color");
        }
        return switch (comp_level) {
            case "qm" -> scoreQM(alliance);
            case "ef", "f", "sf", "qf" -> throw new IllegalArgumentException("Attempting to score " + comp_level + " match which should not be done here");
            default -> 0;
        };
    }

    //TODO Change to compute score per team instead of per alliance
    private int scoreQM(String alliance){
        if(score_breakdown == null){
            return 0;
        }
        int win = winning_alliance.equals(alliance) ? 4 : 0;
        int cargoRP = score_breakdown.get(alliance).cargoBonusRankingPoint ? 1 : 0;
        int climbRP = score_breakdown.get(alliance).hangarBonusRankingPoint ? 1 : 0;
        return win + cargoRP + climbRP;
    }
}
