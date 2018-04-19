package com.frc1699.tst;

import com.frc1699.main.Utils;
import com.frc1699.team.Team;

import java.io.IOException;

public class TBAConnectionTest {

    public static void main(String[] args){
        Team team = new Team("254");
        try {
            System.out.println(Utils.makeRequest(Utils.makeEventListReq(team)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
