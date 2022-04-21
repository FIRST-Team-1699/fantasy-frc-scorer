package com.frc1699.match;

import com.frc1699.main.Constants;
import com.frc1699.main.Utils;

import java.io.IOException;
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

    public Match getMatch(String matchKey) throws IOException {
        if (!matchCache.containsKey(matchKey)) {
            //Get match from TBA and put it into the database
            matchCache.put(matchKey, retrieveMatchData(matchKey));
        }
        return matchCache.get(matchKey);
    }

    private Match retrieveMatchData(final String matchKey) throws IOException {
        String url = Utils.makeMatchReq(matchKey);
        Object obj = Utils.makeRequest(url);
        return Constants.getGson().fromJson((String) obj, Match.class);
    }
}
