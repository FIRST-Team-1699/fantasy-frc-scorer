package com.frc1699.tst;

import com.frc1699.main.Utils;
import com.frc1699.match.Team;
import com.frc1699.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class ScorerTest {

    public static void main(String[] args){
        Team team = new Team("254");
        System.out.println(team.scoreMatches());
    }
}
