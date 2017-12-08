package com.racloop.ti.poc.learn;

import edu.stanford.nlp.ie.crf.CRFClassifier;

public class NerTrainer {

    public static void main(String[] args) throws Exception {
        String[] props1 = {"-prop", "data/config/chem.properties"};
        CRFClassifier.main(props1);
        String[] props2 = {"-prop", "data/config/genus.properties"};
        CRFClassifier.main(props2);
    }
}
