package com.racloop.ti.poc;

import org.apache.commons.text.WordUtils;
import org.junit.Test;

public class BRF005ATest {

    private String input_1 = "Removal of Styrene From Dilute Gaseous Waste Streams Using a Trickle-Bed Bioreactor: Kinetics, Mass Transfer a Modelling of Biodegradation Process";
    private String input_2 = "Waste gas treatment in bioreactors: Environmental engineering aspects";
    private String input_3 = "Co-Treatment Of Single, Binary And Ternary Mixture Gas Of Ethanethiol, Dimethyl Disulfide And Thioanisole In A Biotrickling Filter Seeded With Lysinibacillus sphaericus RG-1";
    private String input_4 = "BIOFILTRATION OF CONCENTRATED MIXTURES OF HYDROGEN SULFIDE AND METHANOL";
    private String input_5 = "Understanding the limits of H2SO4 degrading biotrickling filters using a differential biotrickling filter";
    private String input_6 = "Enhanced removal of NH3";
    private String input_7 = "One-stage biotrickling filter for the removal of a mixture of volatile pollutants from air: Raman spectrometer performance and microbial community analysis.";
    private String input_8 = "Monitoring and control of UV and UV-TiO2 disinfections for municipal Chelatococcus daeguensis wastewater reclamation using artificial neural networks";
    private String input_9 = "An evaluation of tannery industry wastewater treatment sludge gasification by artificial neural network modelling (E. coli)";
    private String input_10 = "Neural networks as a tool for control and management of a biological reactor for treating hydrogen sulfide. Bioproc. Biosyst Bioproc (E. coli)";
    private String input_11 = "Experimental and neural model analysis of styrene removal from polluted air in a biofilter (WHO)";
    private String input_12 = "Survey of UNICEF";

    @Test
    public void test() {
        String input = "A quick brown fox jumps over the lazy dog";
        String output = WordUtils.capitalize(input);
        System.out.println(output);
        output = WordUtils.capitalizeFully(input);
        System.out.println(output);

    }
}
