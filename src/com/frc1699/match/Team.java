package com.frc1699.match;

import com.frc1699.main.Constants;
import com.frc1699.main.Utils;
import com.frc1699.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class Team {

    private final ArrayList<String> events;
    private final String teamNumber;
    private final ArrayList<Match> matches;

    public Team(final String teamNumber){
        this.teamNumber = teamNumber;
        this.matches = new ArrayList<>();
        this.events = new ArrayList<>();
        try {
            this.events.addAll(Parser.listParser((String) Utils.makeRequest(Utils.makeEventListReq(this))));
            this.matches.addAll(Parser.parseMatches((String) Utils.makeRequest(Utils.makeMatchListReq(this, this.getChampEvent()))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getChampEvent(){
        for(String e : this.events){
            if(Constants.getInstance().getChampGameStrings().contains(e)){
                return e;
            }
        }
        return "None";
    }

    public int scoreMatches(){
        int totalScore = 0;
        for(Match m : this.matches){
            try {
                String alliance = getAlliance(m);
                if (m.comp_level.equals("qm")) {
                    MatchResults results = m.score_breakdown.get(alliance);
                    if (m.winning_alliance.equals(alliance)) {
                        totalScore += 3;
                    }
                    if (results.autoQuestRankingPoint) {
                        totalScore += 1;
                    }
                    if (results.faceTheBossRankingPoint) {
                        totalScore += 2;
                    }
                }
            }catch (NullPointerException e){
                System.err.println("Match not played yet.");
            }
        }
        return totalScore;
    }

    private String getAlliance(Match match){
        for(String e : match.alliances.get("red").team_keys) {
            if(this.getTBARequestID().equals(e)){
                return "red";
            }
        }
        return "blue";
    }

    public String getTBARequestID(){
        return "frc" + teamNumber;
    }
    public String getTBAEventID(int index){
        return events.get(index);
    }
}
