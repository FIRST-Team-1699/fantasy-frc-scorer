package com.frc1699.tst;

import com.frc1699.main.Constants;

import java.util.Scanner;

public class EventStatusTest {

    public static void main(String[] args){
        Scanner io = new Scanner(System.in);
        System.out.println("Please enter a TBA auth key: ");
        String TBAAuthKey = io.nextLine();
        System.out.println("Your auth key is: " + TBAAuthKey);

        Constants.getInstance().setTBAAuthKey(TBAAuthKey);
    }

}
