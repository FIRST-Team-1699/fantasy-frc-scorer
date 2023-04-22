package com.frc1699.match;

import com.frc1699.main.Constants;
import com.frc1699.main.Utils;
import com.frc1699.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Team {

    private final String teamNumber;

    private List<String> matches;
    private double qualScore = 0;
    private int numMatchesPlayed = 0;

    public Team(final String teamNumber){
        this.teamNumber = teamNumber;

        //TODO Need to make eventID dynamic
        String rawMatches;
        try {
            rawMatches = (String) Utils.makeRequest(Utils.makeMatchListYearRequest(this, "2023"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rawMatches = rawMatches.replaceAll("\\[", "");
        rawMatches = rawMatches.replaceAll("]", "");
        rawMatches = rawMatches.replaceAll("\n", "");
        rawMatches = rawMatches.replaceAll(" ", "");
        rawMatches = rawMatches.replaceAll("\"", "");

        String[] splitMatches = rawMatches.split(",");
        matches = Arrays.stream(splitMatches).toList();
        matches = matches.stream().filter(Constants::checkEventToScore).collect(Collectors.toList());

        matches.forEach(e -> {
            try{
                String alliance = Arrays.stream(MatchCache.getInstance().getMatch(e).alliances.get("red").team_keys).toList().contains(getTBARequestID()) ? "red" : "blue";
                boolean scoreMatch = !MatchCache.getInstance().getMatch(e).alliances.get(alliance).isSurrogate(this.teamNumber) && !MatchCache.getInstance().getMatch(e).alliances.get(alliance).isDQed(teamNumber);
                if(scoreMatch){
                    qualScore += MatchCache.getInstance().getMatch(e).computeScore(alliance);
//                    System.out.printf("Team %s played match %s and scored %d\n", this, e, MatchCache.getInstance().getMatch(e).computeScore(alliance));
                }
//                else{
//                    System.out.println("======== Team " + teamNumber + " was a surrogate or got DQed ========");
//                }
                // TODO This is the bug
                if(MatchCache.getInstance().getMatch(e).matchPlayed && scoreMatch){
                    numMatchesPlayed++;
                }
            } catch(IllegalArgumentException ex){
                qualScore += 0;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
//        System.out.println(qualScore);
   }

   public double getQualScore(){
        return qualScore;
   }

    public String getTBARequestID(){
        return teamNumber;
    }

    @Override
    public String toString(){
        return teamNumber;
    }

    public int getNumMatchesPlayed(){
        return numMatchesPlayed;
    }
}
