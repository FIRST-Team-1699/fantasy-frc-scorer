package com.frc1699.main;

import com.frc1699.parser.Parser;
import com.frc1699.player.Player;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            String[] lines = Parser.readPickFile("testData/Test_Draft_Data.csv");
            Player[] players = Parser.parsePlayers(lines);
            for (Player p : players)  {
                System.out.printf("%18s -- %f\n", p.getName(), p.sumQualScore());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
