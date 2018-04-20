package com.frc1699.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Parser {

    public static ArrayList<String> parseEventList(String TBAString){
        ArrayList<String> outputList;

        TBAString = TBAString.replaceAll("\\[", "");
        TBAString = TBAString.replaceAll("\\]", "");
        outputList = new ArrayList<>(Arrays.asList(TBAString.split(",")));
        for (int i = 0; i < outputList.size(); i++) {
            outputList.set(i, outputList.get(i).replaceAll("\"", "").trim());
        }

        return outputList;
    }
}
