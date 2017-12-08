package com.racloop.ti.poc.name;

import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;

public class NameSplitter {

    public static void main(String[] args) throws Exception {
        String nameString = "Στυλιανος Αλέξανδρος Παπαδόπουλος";
        searchName(nameString);
    }

    public static void searchName(String name) throws Exception {
        NameParser nameParser = new NameParser();
        PersonNameParserResult result = nameParser.parseName(name);
        NameParser.printName(result);
        System.out.println("**********");
        NameParser.printNames(result);
    }
}
