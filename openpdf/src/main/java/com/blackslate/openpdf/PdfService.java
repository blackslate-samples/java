package com.blackslate.openpdf;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class PdfService {
	
	public void createPDF(String filename) {
		 try {

		    Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		    //create a PDF writer instance and pass output stream
		    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));

		    document.open();
		    document.addAuthor("Author-Name");
		    document.addCreationDate();

		    document.add(new Paragraph("Hello World -- Page 1"));
		    document.add(new Paragraph("This is my first PDF."));

		    document.newPage();

		    document.add(new Paragraph("Hello World -- Page 2"));
		    document.close();
		 }
		 catch(Exception exp) {
		    System.out.println(exp.getMessage());
		 }
	}
	
	
	public void createImagePDF(String inImageFilename, String outFilename) {
		  try {
		       Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		       PdfWriter.getInstance(document, new FileOutputStream(outFilename));
		       document.open();
		       document.addAuthor("Author-Name");
		       document.addCreationDate();

		       document.add(Image.getInstance(inImageFilename));
		       document.close();
		  }
		  catch(Exception exp) {
		     System.out.println(exp.getMessage());
		  }
	}

	public void createPasswordProtectedPDF(String outFilename, String masterPassword, String userPassword) {
		 try {
		     Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		     PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outFilename));

		     //Set owner password and user password.
		     writer.setEncryption(
		    		 		userPassword.getBytes(), //user password
		    		 		masterPassword.getBytes(), //owner password
		                    PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING, 
		                    PdfWriter.STANDARD_ENCRYPTION_128);

		     document.open();
		     document.addAuthor("Author-Name");
		     document.addCreationDate();

		     document.add(new Paragraph("Hello World -- Page 1"));
		     document.add(new Paragraph("This is my first PDF."));

		     document.newPage();

		     document.add(new Paragraph("Hello World -- Page 2"));
		     document.close();
		 }
		 catch(Exception exp) {
		    System.out.println(exp.getMessage());
		 }
	}
	
	public void readPDF(String filename) {
		 try {
		     PdfReader reader = new PdfReader(filename);
		     System.out.println("Document Metadata");
		     System.out.println(reader.getInfo().toString());
		     System.out.println("--");

		     int numPages = reader.getNumberOfPages();
		     for (int index =1; index <= numPages; index++) {
		         byte[] pageBuf = reader.getPageContent(index);
		         String pageContent = new String(pageBuf);
		         System.out.println("Page - " + index);
		         System.out.println(pageContent);
		         System.out.println("");
		     }
		     reader.close();
		 }
		 catch(Exception exp) {
		   System.out.println(exp.getMessage());
		 }
	}
	
	public void extractPDF(String filename) {
		 try {
		     PdfReader reader = new PdfReader(filename);
		     System.out.println("Document Metadata");
		     System.out.println(reader.getInfo().toString());
		     System.out.println("--");

		     //Text Extraction
		     int numPages = reader.getNumberOfPages();
		     PdfTextExtractor textExtractor = new PdfTextExtractor(reader);
		     for (int index =1; index <= numPages; index++) {
		        String pageContent = textExtractor.getTextFromPage(index);
		        System.out.println("Page - " + index);
		        System.out.println(pageContent);
		     }
		     reader.close();
		 }
		 catch(Exception exp) {
		   System.out.println(exp.getMessage());
		 }
		}
}
