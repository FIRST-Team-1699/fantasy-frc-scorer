package com.frc1699.parser.model;

import java.util.Map;

public class Match {
    long actual_time;
    Map<String, Alliance> alliances;
    String comp_level;
    String event_key;
    String key;
    int match_number;
    long post_result_time;
    long predicted_time;
    Map<String, MatchResults> score_breakdown;
    int set_number;
    long time;
    String[] videos;
    String winning_alliance;

    @Override
    public String toString() {
        return "" + actual_time + alliances;
    }
}
