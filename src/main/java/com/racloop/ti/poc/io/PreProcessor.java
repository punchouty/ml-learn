package com.racloop.ti.poc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PreProcessor {

    private static final String OUTPUT_FOLDER = "data/out/";
    private static final String INPUT_FILE_CHEMICALS = "data/in/list_of_chemical_formulas-1246j.csv";
    private static final String INPUT_FILE_GENUS_SPECIES = "data/in/Genus.txt";
    private static final String OUTPUT_FILE_CHEMICALS = OUTPUT_FOLDER + "train_chem.txt";
    private static final String OUTPUT_FILE_GENUS = OUTPUT_FOLDER + "train_genus.txt";
    private static final String CHEMICAL_CLASS = "CHEMICAL";
    private static final String GENUS_CLASS = "GENUS";
    private static final String SPECIES_CLASS = "SPECIES";
    public static final String INPUT_STRING = "Understanding the limits of H2SO4 degrading biotrickling filters using a differential biotrickling filter";

    public static void main(String[] args) throws IOException {
        cleanup();
        preProcessChemicals();
        preProcessGenusSpecies();
    }

    private static void cleanup() {
        File dir = new File(OUTPUT_FOLDER);
        for(File file: dir.listFiles())
            if (!file.isDirectory())
                file.delete();
    }

    private static void preProcessGenusSpecies() throws IOException {
        File fileIn  = new File((INPUT_FILE_GENUS_SPECIES));
        List<String> linesOut = new ArrayList<String>();
        FileLoader loader = new FileLoader();
        List<String> lines = loader.loadLines(fileIn);
        HashSet<String> genuses = new HashSet<String>();
        HashSet<String> species = new HashSet<String>();
        for (String line : lines) {
            if(line != null && line.trim().length() > 0) {
                String [] words = line.split(" ");
                genuses.add(words[0]);
                species.add(words[1]);
            }
        }
        for (String genus : genuses) {
            linesOut.add(genus.trim() + "\t" + GENUS_CLASS + "\n");
        }
        for (String s : species) {
            linesOut.add(s.trim() + "\t" + SPECIES_CLASS + "\n");
        }
        writeFile(linesOut, OUTPUT_FILE_GENUS);
    }

    private static void preProcessChemicals() throws IOException {
        File fileIn  = new File((INPUT_FILE_CHEMICALS));
        FileLoader loader = new FileLoader();
        List<String> lines = loader.loadLines(fileIn);
        List<String> linesOut = new ArrayList<String>();
        for (String line : lines) {
            List<String> words = loader.parseLine(line);
            if(words.size() > 0 && words.get(0) != null && words.get(0).trim().length() > 0) {
                if(!words.get(0).contains(" ")) {
                    linesOut.add(words.get(0) + "\t" + CHEMICAL_CLASS + "\n");
                }
            }
        }
        writeFile(linesOut, OUTPUT_FILE_CHEMICALS);
    }

    private static void writeFile(List<String> lines, String fileName) throws IOException {
        File fileOut = new File(fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        for (String line : lines) {
            bw.write(line);
        }
        bw.close();
    }
}
