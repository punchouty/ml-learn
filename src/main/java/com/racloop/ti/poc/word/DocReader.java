package com.racloop.ti.poc.word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocReader {

//	public static void readDocxFile(String fileName) {
//
//		try {
//			File file = new File(fileName);
//			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//
//			XWPFDocument document = new XWPFDocument(fis);
//
//			List<XWPFParagraph> paragraphs = document.getParagraphs();
//
//			System.out.println("Total no of paragraph "+paragraphs.size());
//			for (XWPFParagraph para : paragraphs) {
//				System.out.println(para.getText());
//			}
//			fis.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static XWPFDocument readDocxFile(File file) {
        FileInputStream fis = null;
        try {
			fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);
			return document;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}