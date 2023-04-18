package com.frc1699.main;

import com.frc1699.parser.Parser;
import com.frc1699.player.Player;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("============================ GROUP 1 ============================");
        System.out.println("=================================================================");
        runScorer("testData/group1Draft.csv");

        System.out.println("=================================================================");
        System.out.println("============================ GROUP 2 ============================");
        System.out.println("=================================================================");
        runScorer("testData/group2Draft.csv");
        System.exit(0);
    }

    private static void runScorer(final String file) {
        try {
            String[] lines = Parser.readPickFile(file);
            Player[] players = Parser.parsePlayers(lines);

            int place = 1;
            for (Player p : Utils.sortPlayers(players))  {
                System.out.printf("%d -- %18s -- %.1f points scored -- %d matches played -- %.4f avg points per match\n", place, p.getName(), p.sumQualScore(), p.sumMatchesPlayed(), p.sumQualScore() / (double) p.sumMatchesPlayed());
                place++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
