package com.racloop.ti.poc.learn;

import com.racloop.ti.poc.io.PreProcessor;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

import java.io.IOException;

public class ChemDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String serializedClassifier = "data/out/chem-model.ser.gz";
        AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);
        System.out.println(classifier.classifyToString(PreProcessor.INPUT_STRING));

    }
}
