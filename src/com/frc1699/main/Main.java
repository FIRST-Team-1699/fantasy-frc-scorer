package com.frc1699.main;

import com.frc1699.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args){
        File f = new File("test_data.txt");
        FileReader fr;

        String TBAString = "";
        try {
            TBAString = new String(Files.readAllBytes(Paths.get(f.getAbsolutePath())), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Parser.parseEventList(TBAString);
        //Constants.getInstance();
    }
}
