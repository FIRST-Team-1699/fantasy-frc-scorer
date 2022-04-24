package com.frc1699.parser;

import com.frc1699.player.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser {

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
