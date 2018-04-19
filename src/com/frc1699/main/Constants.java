package com.frc1699.main;

import java.util.Scanner;

public class Constants {

    private static Constants instance;
    private final String TBAAuthKey;

    public static Constants getInstance(){
        if(instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    private Constants(){
        Scanner io = new Scanner(System.in);
        System.out.println("Please enter a TBA auth key: ");
        this.TBAAuthKey = io.nextLine();
        System.out.println("Your auth key is: " + this.TBAAuthKey);
    }

    public String getTBAAuthKey(){
        return this.TBAAuthKey;
    }

}
