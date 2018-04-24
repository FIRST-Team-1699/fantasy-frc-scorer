package com.frc1699.csvParser;

import com.frc1699.main.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVParser {

    private final Game game;

    public CSVParser(final String filePath){
        this.game = parseCSV(loadCSV(filePath));
    }

    private ArrayList<String> loadCSV(final String filePath){
        ArrayList<String> file = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            while((line = reader.readLine()) != null){
                file.add(line);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            e.printStackTrace();
        }

        return file;
    }

    private Game parseCSV(final ArrayList<String> file){
        //Var init
        String[] players;
        Map<String, ArrayList<Integer>> playerTeamMap = new HashMap<>();
        String playerString = file.get(0).replaceFirst(",", "").trim();

        //Parse players
        players = playerString.split(",");

        //Add keys to map
        for(String player : players){
            playerTeamMap.put(player, new ArrayList<>());
        }

        //Parse teams
        int[][] teamList = new int[8][8];
        for(int i = 0; i < 8; i++){
            String lineToParse = file.get(i + 1).substring(2);
            teamList[i] = parseIntList(lineToParse.split(","));
        }

        return null;
    }

    private int[] parseIntList(String[] list){
        int[] newList = new int[list.length];
        for(int i = 0; i < list.length; i++){
            try {
                newList[i] = Integer.parseInt(list[i]);
            }catch (NumberFormatException e){
                System.out.println("Not a valid number.");
            }
        }
        return newList;
    }

    public Game getGame(){
        return this.game;
    }
}
