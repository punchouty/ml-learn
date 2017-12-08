package com.racloop.ti.poc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLoader {

    public List<String> loadLines(File file) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList();
        try {
            BufferedReader fileReader =
                    new BufferedReader(new FileReader(file));
            String line = fileReader.readLine();
            while (line != null) {
                if(line.startsWith("#")) {// IGNORE HEADER
                    line = fileReader.readLine();
                    continue;
                }
                lines.add(line);
                line = fileReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> parseLine(String line) {
        if(line == null && line.trim().length() <= 0) {
            return null;
        }
        String [] tokens = line.split(",");
        return new ArrayList(Arrays.asList(tokens));

    }
}