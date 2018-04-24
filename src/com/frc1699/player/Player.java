package com.frc1699.player;

import com.frc1699.match.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private final Map<Team, Integer> teamMap;

    public Player(final String name, final Team[] teams){
        this.name = name;
        teamMap = new HashMap<>();
        for(Team e : teams){
            teamMap.put(e, 0);
        }
    }

    public Player(final String name, final ArrayList<String> teams){
        this.name = name;
        teamMap = new HashMap<>();
        for(String e : teams){
            teamMap.put(new Team(e), 0);
        }
    }

    public int getScore(String teamNum){
        return teamMap.get(teamNum);
    }

    public void update(){
        for(Map.Entry<Team, Integer> e : teamMap.entrySet()){
            updateScore(e.getKey(), e.getKey().scoreMatches());
        }
    }

    private void updateScore(Team team, int newScore){
        teamMap.put(team, newScore);
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        int totalScore = 0;
        for(Map.Entry<Team, Integer> e : teamMap.entrySet()){
            totalScore += teamMap.get(e.getKey());
        }
        return totalScore;
    }
}
