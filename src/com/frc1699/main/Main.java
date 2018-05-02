package com.frc1699.main;

import com.frc1699.ui.Window;

public class Main {

    public static void main(String[] args) {

        // Code for creating a game without a GUI
//        Scanner io = new Scanner(System.in);
//        System.out.println("Please enter a TBA auth key: ");
//        String TBAAuthKey = io.nextLine();
//        System.out.println("Your auth key is: " + TBAAuthKey);
//
//        Constants.getInstance().setTBAAuthKey(TBAAuthKey);
//
//        CSVParser parser = new CSVParser("testData/Detroit_Draft.csv");
//        Game g =  parser.getGame();
//
//        for(Player e : g.getPlayerList()){
//            e.update();
//            System.out.println(e.getName() + " : " + e.getScore());
//        }

        //Code for creating a game with a GUI
        Window window = new Window(800, 600, "Fantasy FRC");
    }
}
