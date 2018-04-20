package com.frc1699.main.player;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private final Map<String, Integer> teamMap;

    public Player(final String name, final String[] teams){
        this.name = name;
        teamMap = new HashMap<>();
        for(String e : teams){
            teamMap.put(e, 0);
        }
    }

    public int getScore(String teamNum){
        return teamMap.get(teamNum);
    }

    public void updateScore(String teamNum, int newScore){
        teamMap.put(teamNum, newScore);
    }

    public String getName(){
        return this.name;
    }
}
