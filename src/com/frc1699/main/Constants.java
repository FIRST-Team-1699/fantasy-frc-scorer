package com.frc1699.main;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

    private static final Properties properties;
    private static final Gson gson;
    private static final OkHttpClient client;

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
}
