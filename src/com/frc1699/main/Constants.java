package com.frc1699.main;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Constants {

    private static Constants instance;
    private String TBAAuthKey;
    private final OkHttpClient client;
    private final Gson gson;
    private final ArrayList<String> champGameStrings;
    private File pathToCSV;

    public static Constants getInstance(){
        if(instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    private Constants(){
        this.champGameStrings = new ArrayList<>();
        champGameStrings.add("2018carv");
        champGameStrings.add("2018gal");
        champGameStrings.add("2018hop");
        champGameStrings.add("2018new");
        champGameStrings.add("2018roe");
        champGameStrings.add("2018tur");
        champGameStrings.add("2018arc");
        champGameStrings.add("2018cars");
        champGameStrings.add("2018cur");
        champGameStrings.add("2018dal");
        champGameStrings.add("2018dar");
        champGameStrings.add("2018tes");

        this.gson = new Gson();
        this.client = new OkHttpClient();
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

}
