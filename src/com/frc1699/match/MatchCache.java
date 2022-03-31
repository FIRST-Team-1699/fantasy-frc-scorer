package com.frc1699.match;

import java.util.HashMap;
import java.util.Map;

//Returns a match with a given match id or retrieves it from TBA if its not in the cache
public class MatchCache {

    private static MatchCache instance;

    public static MatchCache getInstance(){
        if(instance == null){
            instance = new MatchCache();
        }
        return instance;
    }

    private final Map<String, Match> matchCache;

    private MatchCache(){
        matchCache = new HashMap<>();
    }

    public Match getMatch(String matchKey){
        if(matchCache.containsKey(matchKey)){
            return matchCache.get(matchKey);
        }else{
            //Get match from TBA and put it into the database
            //TODO Get match from TBA
            //Return the match
            return null;
        }
    }
}
