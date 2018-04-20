package com.frc1699.tst;

import com.frc1699.main.Utils;
import com.frc1699.match.Team;

import java.io.IOException;

public class TBAConnectionTest {

    public static void main(String[] args){
        Team team = new Team("1699");
        try {
            Object output = Utils.makeRequest(Utils.makeEventListReq(team));
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
