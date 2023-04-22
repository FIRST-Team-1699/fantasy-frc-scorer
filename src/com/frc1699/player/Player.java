package com.frc1699.player;

import com.frc1699.match.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player implements Comparable<Player>{

    private final String name;
    private final Map<Team, Integer> teamMap;

    public Player(final String name, final ArrayList<String> teams){
        this.name = name;
        teamMap = new HashMap<>();
        for(String e : teams){
            teamMap.put(new Team("frc" + e), Integer.parseInt(e));
        }
    }

    public double sumQualScore(){
        System.out.println("-------- Summing score for " + this.name + " --------");
        double score = 0.0;
        for(Map.Entry<Team, Integer> team : teamMap.entrySet()){
            System.out.println("\tScoring team " + team.getKey().toString());
            score += team.getKey().getQualScore();
        }
        return score;
    }

    public int sumMatchesPlayed(){
        int numMatchesPlayed = 0;
        for(Map.Entry<Team, Integer> team : teamMap.entrySet()){
            numMatchesPlayed += team.getKey().getNumMatchesPlayed();
        }
        return numMatchesPlayed;
    }

    public String getName(){
        return this.name;
    }

    //Gets the total score for this player
    public int getScore(){
        int totalScore = 0;
        for(Map.Entry<Team, Integer> e : teamMap.entrySet()){
            totalScore += teamMap.get(e.getKey());
        }
        return totalScore;
    }

    public Map<Team, Integer> getTeamMap(){
        return this.teamMap;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Player p) {
        if(sumQualScore() / (double) sumMatchesPlayed() == p.sumQualScore() / (double) p.sumMatchesPlayed()){
            return 0;
        }
        return sumQualScore() / (double) sumMatchesPlayed() > p.sumQualScore() / (double) p.sumMatchesPlayed() ? -1 : 1;
    }
}
