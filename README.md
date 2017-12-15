## NER

* Chemical Compounds : https://en.wikipedia.org/wiki/List_of_CAS_numbers_by_chemical_compound
* Genus Species : http://1kai.dokkyomed.ac.jp/mammal/en/index_sci.html

* Sample property file

`
trainFile = training-data.col
serializeTo = ner-model.ser.gz
map = word=0,answer=1

useClassFeature=true
useWord=true
useNGrams=true
noMidNGrams=true
maxNGramLeng=6
usePrev=true
useNext=true
useSequences=true
usePrevSequences=true
maxLeft=1
useTypeSeqs=true
useTypeSeqs2=true
useTypeySequences=true
wordShape=chris2useLC
useDisjunctive=true
`

### Help on NER
* Look at 9th Lesson And Above - https://www.youtube.com/watch?v=nfoudtpBV68&list=PL4LJlvG_SDpxQAwZYtwfXcQr7kGnl9W93
* https://stanfordnlp.github.io/CoreNLP/ner.html
* https://stanfordnlp.github.io/CoreNLP/regexner.html
* Training New Model - https://nlp.stanford.edu/software/crf-faq.html#a
* https://nlp.stanford.edu/software/CRF-NER.html 

## Commands

1. java -cp stanford-corenlp-3.8.0.jar edu.stanford.nlp.process.PTBTokenizer train.txt > tokens.txt
1. java -cp stanford-corenlp-3.8.0.jar edu.stanford.nlp.ie.crf.CRFClassifier -prop data/config/chem.properties
1. /Users/rajanpunchouty/dev/tools/corenlp/stanford-ner-2017-06-09/ner-gui.sh

## Other Notes

* Training Algorithm : https://www.youtube.com/watch?v=42NQ5ORqQIM
* Language Detection : https://github.com/shuyo/language-detection (Naive Bayes, N-Grams)
* https://github.com/optimaize/language-detector/tree/master/src/main/java

## Some Random Links
* https://www.linkedin.com/in/davidkuilman/
* https://www.youtube.com/watch?v=Q9Z20HCPnww&index=5&list=PLVZqlMpoM6kbaeySxhdtgQPFEC5nV7Faa
* https://2016.semantics.cc/david-kuilman-0
* https://www.clarifai.com/
* http://clarify.io/
* https://einstein.ai/ -> metamind
* https://www.h2o.ai/