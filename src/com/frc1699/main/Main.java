package com.frc1699.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner io = new Scanner(System.in);
        System.out.println("Please enter a TBA auth key: ");
        final String TBAKey = io.nextLine();
        Constants.makeInstance(TBAKey);
        System.out.println("Your auth key is: " + TBAKey);
    }
}
