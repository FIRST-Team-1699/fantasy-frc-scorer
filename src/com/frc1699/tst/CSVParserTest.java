package com.frc1699.tst;

import com.frc1699.csvParser.CSVParser;
import com.frc1699.main.Game;

public class CSVParserTest {

    public static void main(String[] args){
        CSVParser testParser = new CSVParser("testData/Detroit_Draft.csv");

        Game game = testParser.getGame();
        game.getPlayerList().forEach(System.out::println);
    }
}
