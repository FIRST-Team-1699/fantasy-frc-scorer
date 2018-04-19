package com.frc1699.main;

public class Constants {

    private static Constants instance;
    private final String TBAAuthkey;

    public static Constants getInstance(){
        if(instance == null) {
            instance = new Constants("");
        }
        return instance;
    }

    public static void makeInstance(final String TBAAuthKey){
        instance = new Constants(TBAAuthKey);
    }

    private Constants(final String TBAAuthKey){
        this.TBAAuthkey = TBAAuthKey;
    }

    public String getTBAAuthKey(){
        return this.TBAAuthkey;
    }

}
