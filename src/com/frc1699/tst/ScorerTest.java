package com.frc1699.tst;

import com.frc1699.main.Constants;
import com.frc1699.match.Team;

import java.util.Scanner;

public class ScorerTest {

    public static void main(String[] args){
        Scanner io = new Scanner(System.in);
        System.out.println("Please enter a TBA auth key: ");
        String TBAAuthKey = io.nextLine();
        System.out.println("Your auth key is: " + TBAAuthKey);

        Constants.getInstance().setTBAAuthKey(TBAAuthKey);
        Team team = new Team("254");
        System.out.println(team.scoreMatches());
    }
}
