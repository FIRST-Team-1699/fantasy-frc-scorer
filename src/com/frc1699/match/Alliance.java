package com.frc1699.match;

import java.util.Arrays;

public class Alliance {

    String[] dq_team_keys;
    int score;
    String[] surrogate_team_keys;
    String[] team_keys;

    public boolean isSurrogate(String teamID){
        return Arrays.stream(surrogate_team_keys).toList().contains(teamID);
    }

    @Override
    public String toString() {
        return "" + team_keys[0] + ":" + team_keys[1] + ":" + team_keys[2] + ":" + score;
    }
}