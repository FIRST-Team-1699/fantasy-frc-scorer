package com.frc1699.tst;

import com.frc1699.main.Utils;
import com.frc1699.parser.Parser;
import com.frc1699.match.Team;

import java.io.IOException;
import java.util.ArrayList;

public class MatchParserTest {

    public static void main(String[] args){
        Team team = new Team("254");
        try {
            Object output = Utils.makeRequest(Utils.makeEventListReq(team));
            ArrayList<String > events = Parser.listParser((String) output);
            System.out.println(output);
            Object matches = Utils.makeRequest(Utils.makeMatchListReq(team, events.get(2)));
            System.out.println(matches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
