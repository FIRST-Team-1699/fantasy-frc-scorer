package com.frc1699.team;

import com.frc1699.main.Constants;
import com.frc1699.main.Utils;
import com.frc1699.match.Match;
import com.frc1699.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class Team {

    //TODO Add matches for events

    private final ArrayList<String> events;
    private final String teamNumber;
    private final ArrayList<Match> matches;
    private final String champEvent;

    public Team(final String teamNumber){
        this.teamNumber = teamNumber;
        this.matches = new ArrayList<>();
        this.events = new ArrayList<>();
        try {
            this.events.addAll(Parser.listParser((String) Utils.makeRequest(Utils.makeEventListReq(this))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.champEvent = getChampEvent();
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
        return 0;
    }

    public String getTBARequestID(){
        return "frc" + teamNumber;
    }
    public String getTBAEventID(int index){
        return events.get(index);
    }
}
