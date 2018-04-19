package com.frc1699.main;

import com.frc1699.team.Team;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Utils {

    public static Object makeRequest(final String reqURL) throws IOException {
        Request request = new Request.Builder().url(reqURL).build();

        Response response = Constants.getInstance().getClient().newCall(request).execute();
        return response.body().string();
    }

    public static String makeMatchListReq(final Team team){
        return null;
    }

    public static String makeEventListReq(final Team team){
        String outputString = "https://www.thebluealliance.com/api/v3/team/" + team.getTBARequestID() + "/2018/keys";
        return outputString;
    }

    public static String makeMatchReq(final Team team){
        return null;
    }
}
