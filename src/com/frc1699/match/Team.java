package com.frc1699.match;

import com.frc1699.main.Utils;
import com.frc1699.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private final String teamNumber;

    private final List<String> matches;
    private double qualScore = 0;

    public Team(final String teamNumber){
        this.teamNumber = teamNumber;

        //TODO Need to make eventID dynamic
        String rawMatches;
        try {
            rawMatches = (String) Utils.makeRequest(Utils.makeMatchListRequest(this, "2022cada"));
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

        matches.forEach(e -> {
            try{
                //TODO Determine alliance
                qualScore += MatchCache.getInstance().getMatch(e).computeScore("red");
            } catch(IllegalArgumentException ex){
                qualScore += 0;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        System.out.println(qualScore);
   }

    public String getTBARequestID(){
        return "frc" + teamNumber;
    }

    @Override
    public String toString(){
        return teamNumber;
    }
}
