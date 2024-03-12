package com.bos.htmlparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
	
	
	public void parse( ) throws IOException {
		
		//Document htmlDoc = Jsoup.connect("https://en.wikipedia.org").get();
		
		File inputFile = new File("html-file.html");
		File outputFile = new File("output.html");
		
		Document htmlDoc = Jsoup.parse(inputFile);
		
		Elements metaTags = htmlDoc.getElementsByTag("meta");
		metaTags.forEach(metaTag -> {
			System.out.println(metaTag.attribute("property") + " " + metaTag.attribute("content"));
		});

		Elements imgTags = htmlDoc.getElementsByTag("img");
		imgTags.forEach(imgTag -> System.out.println(imgTag.attribute("src")));
		
		htmlDoc.getElementsByAttributeValue(null, null)
		
		
		Elements footerElements =  htmlDoc.select(".footer"); //htmlDoc.getElementsByClass("footer");
		Iterator<Element> itr = footerElements.iterator();
		while(itr.hasNext()) {
			Element footerElement = itr.next();
			Elements links = footerElement.select("a[href]");
			links.forEach(linkTag -> System.out.println(linkTag.attribute("href")));			
		}
		
		Elements formElements =  htmlDoc.select(".form"); 
		Iterator<Element> itr1 = formElements.iterator();
		while(itr1.hasNext()) {
			Element formElement = itr1.next();
			Elements buttonElements = formElement.select("[type=button]");
			buttonElements.forEach(buttonElement -> System.out.println(buttonElement.attr("name")));
		}
		
		Elements sectionElements =  htmlDoc.getElementsByClass("section2"); 
		sectionElements.attr("data-key", "data-value");
		Iterator<Element> itr2 = sectionElements.iterator();
		while(itr2.hasNext()) {
			Element formElement = itr2.next();
			formElement.addClass("new-class");
		}
		
		String htmlContent = htmlDoc.outerHtml();
		Files.writeString(outputFile.toPath(), htmlContent, StandardOpenOption.CREATE_NEW);
	}

}
