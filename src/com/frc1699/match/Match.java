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


    boolean matchPlayed = true;
    private int scoreQM(String alliance){
        if(score_breakdown == null){
            matchPlayed = false;
            return 0;
        }
        int win;
        if(winning_alliance.equals("")){
            win = 2;
        }else{
            win = winning_alliance.equals(alliance) ? 4 : 0;
        }
        int cargoRP = score_breakdown.get(alliance).cargoBonusRankingPoint ? 1 : 0;
        int climbRP = score_breakdown.get(alliance).hangarBonusRankingPoint ? 1 : 0;
        return win + cargoRP + climbRP;
    }
}
