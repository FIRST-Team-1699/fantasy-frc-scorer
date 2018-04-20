package com.frc1699.match;

import com.frc1699.main.Constants;
import com.frc1699.main.Utils;
import com.frc1699.match.Match;
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
            this.matches.addAll(Parser.parseMatches(Utils.makeMatchListReq(this, this.getChampEvent())));
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
            String alliance = getAlliance(m);
            MatchResults results = m.score_breakdown.get(alliance);
            if(m.winning_alliance.equals(alliance)){
                totalScore += 6;
            }
            if(results.autoQuestRankingPoint){
                totalScore += 1;
            }
            if(results.faceTheBossRankingPoint){
                totalScore += 2;
            }
        }
        return totalScore;
    }

    private String getAlliance(Match match){
        for(String e : match.alliances.get("red").team_keys) {
            if(this.teamNumber == e){
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
