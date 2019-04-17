package com.frc1699.main;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;

import java.io.File;
import java.util.ArrayList;

public class Constants {

    private static Constants instance;

    //Stores Blue Alliance Auth key
    private String TBAAuthKey;

    private final OkHttpClient client;
    private final Gson gson;

    //Stores valid event strings for championship fields
    private final ArrayList<String> champGameStrings;
    private File pathToCSV;
    private String year;

    //Stores scores for alliance selection
    private final int[][] allianceSelectionScoringGuide;

    public static Constants getInstance(){
        if(instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    private Constants(){
        //Adds event strings to champ event list
        this.champGameStrings = new ArrayList<>();
        champGameStrings.add("2019carv");
        champGameStrings.add("2019gal");
        champGameStrings.add("2019hop");
        champGameStrings.add("2019new");
        champGameStrings.add("2019roe");
        champGameStrings.add("2019tur");
        champGameStrings.add("2019arc");
        champGameStrings.add("2019cars");
        champGameStrings.add("2019cur");
        champGameStrings.add("2019dal");
        champGameStrings.add("2019dar");
        champGameStrings.add("2019tes");

        this.gson = new Gson();
        this.client = new OkHttpClient();

        //Makes alliance selection scoring guide
        allianceSelectionScoringGuide = new int[][]{
                {24, 20, 9, 12},
                {23, 19, 10, 11},
                {22, 18, 11, 10},
                {21, 17, 12, 9},
                {20, 16, 13, 8},
                {19, 15, 14, 7},
                {18, 14, 15, 6},
                {17, 13, 16, 5}
        };
    }

    public int[][] getAllianceSelectionScoringGuide(){
        return this.allianceSelectionScoringGuide;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public Gson getGson() {
        return gson;
    }

    public ArrayList<String> getChampGameStrings(){
        return this.champGameStrings;
    }

    public String getTBAAuthKey(){
        return this.TBAAuthKey;
    }

    public File getPathToCSV(){
        return pathToCSV;
    }

    public void setPathToCSV(File file){
        this.pathToCSV = file;
    }

    public void setTBAAuthKey(String key){
        this.TBAAuthKey = key;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getYear(){
        return this.year;
    }

}
