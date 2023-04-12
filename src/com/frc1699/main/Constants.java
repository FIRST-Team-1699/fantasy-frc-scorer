package com.frc1699.main;

import com.frc1699.player.Player;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Constants {

    private static final Properties properties;
    private static final Gson gson;
    private static final OkHttpClient client;

    private static final Set<String> eventsToScore;

    static {
        properties = new Properties();
        InputStream inputStream = Constants.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        gson = new Gson();
        client = new OkHttpClient();

        eventsToScore = Set.of("2023carv", "2023tur", "2023gal", "2023roe", "2023hop", "2023new");
    }

    public static Properties getProperties(){
        return properties;
    }

    public static String getTBAAuthKey(){
        return properties.getProperty("tbakey");
    }
    
    public static OkHttpClient getClient(){
        return client;
    }

    public static Gson getGson() {
        return gson;
    }

    public static boolean checkEventToScore(String match){
        String[] splitMatchStr = match.split("_");
        return eventsToScore.contains(splitMatchStr[0]);
    }
}
