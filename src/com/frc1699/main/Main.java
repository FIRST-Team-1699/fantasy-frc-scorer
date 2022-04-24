package com.frc1699.main;

import com.frc1699.parser.Parser;
import com.frc1699.player.Player;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            String[] lines = Parser.readPickFile("testData/worlds2022draft.csv");
            Player[] players = Parser.parsePlayers(lines);

            int place = 1;
            for (Player p : Utils.sortPlayers(players))  {
                System.out.printf("%d -- %18s -- %.1f points scored -- %d matches played -- %.4f avg points per match\n", place, p.getName(), p.sumQualScore(), p.sumMatchesPlayed(), p.sumQualScore() / (double) p.sumMatchesPlayed());
                place++;
            }
            System.exit(0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
