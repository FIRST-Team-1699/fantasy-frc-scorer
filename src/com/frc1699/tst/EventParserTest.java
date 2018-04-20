package com.frc1699.tst;

import com.frc1699.main.Utils;
import com.frc1699.parser.Parser;
import com.frc1699.team.Team;

import java.io.IOException;
import java.util.ArrayList;

public class EventParserTest {

    public static void main(String[] args){
        Team team = new Team("254");
        try {
            Object output = Utils.makeRequest(Utils.makeEventListReq(team));
            ArrayList<String > events = Parser.listParser((String) output);
            for(String e : events){
                System.out.println(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
