package com.frc1699.main;

import com.frc1699.csvParser.CSVParser;
import com.frc1699.match.Team;
import com.frc1699.player.Player;

public class Main {

    public static void main(String[] args) {
        Constants.getInstance();

        CSVParser parser = new CSVParser("testData/Detroit_Draft.csv");
        Game g =  parser.getGame();

        for(Player e : g.getPlayerList()){
            e.update();
            System.out.println(e.getName() + " : " + e.getScore());
        }
    }
}
