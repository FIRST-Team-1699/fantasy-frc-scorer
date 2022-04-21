package com.frc1699.main;

import com.frc1699.parser.Parser;
import com.frc1699.player.Player;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            String[] lines = Parser.readPickFile("testData/worlds2022draft.csv");
            Player[] players = Parser.parsePlayers(lines);

            for (Player p : Utils.sortPlayers(players))  {
                System.out.printf("%18s -- %.1f\n", p.getName(), p.sumQualScore());
            }
            System.exit(0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
