package com.racloop.ti.poc.lang;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

import java.io.IOException;
import java.util.List;

public class LanguageDetection {

    public static void main(String[] args) throws IOException {
        List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
//        for (LanguageProfile languageProfile : languageProfiles) {
//            System.out.println("Language : " + languageProfile.getLocale());
//        }
        LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .withProfiles(languageProfiles)
                .build();
        TextObjectFactory textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();
        TextObject textObject = textObjectFactory.forText("Sánchez-Gil, Oberflächenplasmonresonanzen Von Metallischen Nanostars / Nanoflowers Für Oberflächenverstärkte Raman-Streuung");
        Optional<LdLocale> lang = languageDetector.detect(textObject);
        if(lang.isPresent()) {
            LdLocale locale = lang.get();
            System.out.println("Locale : " + locale.toString() + " | " + locale.getRegion());
        }
        else {
            System.out.println("none");
        }
    }
}
