package com.frc1699.parser;

import com.frc1699.event.Team;
import com.frc1699.main.Constants;
import com.frc1699.match.Match;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    public static ArrayList<String> listParser(String TBAString){
        ArrayList<String> outputList;

        TBAString = TBAString.replaceAll("\\[", "");
        TBAString = TBAString.replaceAll("\\]", "");
        outputList = new ArrayList<>(Arrays.asList(TBAString.split(",")));
        for (int i = 0; i < outputList.size(); i++) {
            outputList.set(i, outputList.get(i).replaceAll("\"", "").trim());
        }

        return outputList;
    }

    public static ArrayList<Match> parseMatches(String JsonData) {
        Match[] matches = Constants.getInstance().getGson().fromJson(JsonData, Match[].class);
        return new ArrayList<Match>(Arrays.asList(matches));
    }

    public static Team parseTeamStatus(String JsonData){
        Team team = Constants.getInstance().getGson().fromJson(JsonData, Team.class);
        return team;
    }
}
