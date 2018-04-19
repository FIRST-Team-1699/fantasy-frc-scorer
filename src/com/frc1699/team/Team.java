package com.frc1699.team;

import com.frc1699.player.Player;

import java.util.ArrayList;

public class Team {

    private final ArrayList<String> events;
    private final String teamNumber;

    public Team(final String teamNumber){
        this.teamNumber = teamNumber;
        this.events = new ArrayList<>(); //TODO Get event list from TBA API
    }

    public Team(final String teamNumber, final ArrayList<String> events){
        this.teamNumber = teamNumber;
        this.events = events;
    }

    public Team(final String teamNumber, final String[] events){
        this.teamNumber = teamNumber;
        this.events = new ArrayList<>();
        for(String e : events) {
            this.events.add(e);
        }
    }
}
