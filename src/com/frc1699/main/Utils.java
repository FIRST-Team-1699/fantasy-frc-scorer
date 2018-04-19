package com.frc1699.main;

public class Utils {

    public static Object makeRequest(final String reqURL){


        return null;
    }

    public static String buildRequestURL(final RequestType reqType, final String teamNumber){
        switch(reqType){
            case MatchReq:
                return makeMatchReq();
            case EventListReq:
                return makeEventListReq();
            case MatchListReq:
                return makeMatchListReq();
        }
        return "Bad Req";
    }

    private static String makeMatchListReq(){
        return null;
    }

    private static String makeEventListReq(){
        return null;
    }

    private static String makeMatchReq(){
        return null;
    }
}
