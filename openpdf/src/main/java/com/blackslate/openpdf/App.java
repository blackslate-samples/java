package com.blackslate.openpdf;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	PdfService pdfService = new PdfService();
    	
    	pdfService.createPDF("mypdf.pdf");
    	
    	pdfService.createImagePDF("test-image.png", "myimage.pdf");
    	
    	pdfService.readPDF("mypdf.pdf");
    	
    	pdfService.createPasswordProtectedPDF("pass.pdf", "master123", "user123");
    	
    	pdfService.extractPDF("mypdf.pdf");
    	
    }
}
