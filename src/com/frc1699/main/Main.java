package com.frc1699.main;

import com.frc1699.csvParser.CSVParser;
import com.frc1699.match.Team;
import com.frc1699.player.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("Please enter a TBA auth key: ");
        String TBAAuthKey = io.nextLine();
        System.out.println("Your auth key is: " + TBAAuthKey);

        Constants.getInstance().setTBAAuthKey(TBAAuthKey);

        CSVParser parser = new CSVParser("testData/Detroit_Draft.csv");
        Game g =  parser.getGame();

        for(Player e : g.getPlayerList()){
            e.update();
            System.out.println(e.getName() + " : " + e.getScore());
        }
    }
}
