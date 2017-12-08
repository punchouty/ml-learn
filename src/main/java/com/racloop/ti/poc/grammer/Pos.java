package com.racloop.ti.poc.grammer;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class Pos {

    private static final String SENTENCE = "Experimental and neural model analysis of styrene removal from polluted air in a biofilter";

    public static void main(String[] args) {
        all();
    }

    private static void all() {
        StanfordCoreNLP pipeline;
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, ner");
        pipeline = new StanfordCoreNLP(props, false);
        Annotation document = pipeline.process(SENTENCE);
        for(CoreMap sentence: document.get(CoreAnnotations.SentencesAnnotation.class)) {
            for(CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                System.out.println(word + " | POS : " + pos  + ", NER : " + ne);
            }
        }
    }
}
