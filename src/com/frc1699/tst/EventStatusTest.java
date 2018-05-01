package com.frc1699.tst;

import com.frc1699.main.Constants;
import com.frc1699.main.Utils;
import com.frc1699.match.Team;
import com.frc1699.parser.Parser;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class EventStatusTest {

    public static void main(String[] args){
        Scanner io = new Scanner(System.in);
        System.out.println("Please enter a TBA auth key: ");
        String TBAAuthKey = io.nextLine();
        System.out.println("Your auth key is: " + TBAAuthKey);

        Constants.getInstance().setTBAAuthKey(TBAAuthKey);
        com.frc1699.match.Team poofs = new Team("254");
        try {
            com.frc1699.event.Team team = Parser.parseTeamStatus((String) Utils.makeRequest(Utils.makeTeamEventStatusRequest(poofs, "2018casj")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
