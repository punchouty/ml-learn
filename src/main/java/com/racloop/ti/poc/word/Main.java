package com.racloop.ti.poc.word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("data/AUN001.docx");
        if(file.exists()) {
            XWPFDocument document = DocReader.readDocxFile(file);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            int i = 0;
            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
//                System.out.println(i++ + " : " + para.getText());
                List<XWPFRun> runs = para.getRuns();
                for (XWPFRun run : runs) {
//                    System.out.println("CharacterSpacing : " + run.getCharacterSpacing() + " | Color : " + run.getColor()
//                            + " | FontFamily : " + run.getFontFamily() + " | FontName : " + run.getFontName() + " | FontSize : " + run.getFontSize()
//                            + " | TextPosition : " + run.getTextPosition() + " | StrikeThrough : " + run.isStrikeThrough() + " | Italic : " + run.isItalic()
//                            + " | Kerning : " + run.getKerning()+ " | Subscript : " + run.getSubscript()+ " | Underline : " + run.getUnderline()+ " | isBold : " + run.isBold());
//                    System.out.println(run);
                }
//                break;
            }
        }
        else {
            System.err.println("File don't Exists");
        }

    }

}
