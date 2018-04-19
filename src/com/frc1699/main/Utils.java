package com.frc1699.main;

import com.frc1699.team.Team;

public class Utils {

    public static Object makeRequest(final String reqURL) throws InvalidURLException {
        if(reqURL.equals("Bad Req")){
            throw new InvalidURLException();
        }

        return null;
    }

    public static String buildRequestURL(final RequestType reqType, final Team team){
        switch(reqType){
            case MatchReq:
                return makeMatchReq(team);
            case EventListReq:
                return makeEventListReq(team);
            case MatchListReq:
                return makeMatchListReq(team);
        }
        return "Bad Req";
    }

    private static String makeMatchListReq(final Team team){
        return null;
    }

    private static String makeEventListReq(final Team team){
        String outputString = "https://www.thebluealliance.com/api/v3/team/" + team.getTBARequestID() + "/2018/keys";
        return outputString;
    }

    private static String makeMatchReq(final Team team){
        return null;
    }
}
