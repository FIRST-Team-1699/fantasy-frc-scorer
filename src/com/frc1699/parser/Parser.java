package com.frc1699.parser;

import com.frc1699.event.Team;
import com.frc1699.main.Constants;
import com.frc1699.match.Match;
import com.frc1699.player.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser {

    //Takes a list that in input as a string and parses it to an ArrayList
    public static ArrayList<String> listParser(String TBAString){
        ArrayList<String> outputList;

        //Removes [] in the front and back of the string
        TBAString = TBAString.replaceAll("\\[", "");
        TBAString = TBAString.replaceAll("\\]", "");

        //Splits the string at ","
        outputList = new ArrayList<>(Arrays.asList(TBAString.split(",")));

        //Removes new lines
        for (int i = 0; i < outputList.size(); i++) {
            outputList.set(i, outputList.get(i).replaceAll("\"", "").trim());
        }

        return outputList;
    }

    //Parses JSon match data
    public static ArrayList<Match> parseMatches(String JsonData) {
        Match[] matches = Constants.getGson().fromJson(JsonData, Match[].class);
        return new ArrayList<>(Arrays.asList(matches));
    }

    //Parses JSon match status
    public static Team parseTeamStatus(String JsonData){
        return Constants.getGson().fromJson(JsonData, Team.class);
    }

    public static Player[] parsePlayers(String[] input){
        String[] players = input[0].split(",");
        final int numPlayers = players.length;
        final int teamsPerPlayer = input.length - 1;

        Map<String, ArrayList<String>> teamsForPlayer = new HashMap<>();
        for(String player : players){
            teamsForPlayer.put(player, new ArrayList<>());
        }

        for(int i = 0; i < teamsPerPlayer; i++){
            String line = input[i + 1];
            String[] splitLine = line.split(",");
            for(int j = 0; j < splitLine.length; j++){
                String player = players[j];
                teamsForPlayer.get(player).add(splitLine[j]);
            }
        }

        Player[] playersList = new Player[numPlayers];
        for(int i  = 0; i < numPlayers; i++){
            playersList[i] = new Player(players[i], teamsForPlayer.get(players[i]));
        }

        return playersList;
    }

    public static String[] readPickFile(final String filePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner reader = new Scanner(new File(filePath));
        while(reader.hasNextLine()){
            lines.add(reader.nextLine());
        }
        reader.close();
        return lines.toArray(new String[0]);
    }
}
