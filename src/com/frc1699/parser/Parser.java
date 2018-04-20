package com.frc1699.parser;

import com.frc1699.parser.model.Match;
import com.google.gson.Gson;
import java.util.ArrayList;

public class Parser {

    public static ArrayList<String> parseEventList(String TBAString){
        /*ArrayList<String> outputList;

        TBAString = TBAString.replaceAll("\\[", "");
        TBAString = TBAString.replaceAll("\\]", "");
        outputList = new ArrayList<>(Arrays.asList(TBAString.split(",")));
        for (int i = 0; i < outputList.size(); i++) {
            outputList.set(i, outputList.get(i).replaceAll("\"", "").trim());
        }

        return outputList;*/

        // Make a gson object and tell it to parse the json data into an array of Matches
        Gson gson = new Gson();
        Match[] matches = gson.fromJson(TBAString, Match[].class);

        for (Match m : matches) {
            System.out.println(m.toString());
        }

        return null;
    }
}
