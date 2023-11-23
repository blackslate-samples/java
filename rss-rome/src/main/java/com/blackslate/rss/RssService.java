package com.blackslate.rss;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndCategoryImpl;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;

public class RssService {
	
	public void readRssXml() throws IllegalArgumentException, FeedException, IOException {
		
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(new File("C:\\test\\rss.xml")));
		
		List<SyndEntry>feedEntries = feed.getEntries();
		feedEntries.forEach(entry -> {
			System.out.println(entry.getTitle());
			System.out.println(entry.getLink());
		});
		
	}

	public void writeRssXml() throws IOException, FeedException {
		
		//create feed
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");
        feed.setTitle("Blackslate");
        feed.setLink("https://www.blackslate.io");
        feed.setDescription("Educate and Empower software professionals");
        
        //Set category
  		ArrayList<SyndCategory> synedCatList = new ArrayList<SyndCategory>();
  		SyndCategory syndCat = new SyndCategoryImpl();
        syndCat.setName("article");
        synedCatList.add(syndCat);
        
        //Add entry
        ArrayList<SyndEntry> rssEntries = new ArrayList<SyndEntry>(20);
        
        SyndContent syndContent = new SyndContentImpl();
        syndContent.setType("text/html");
        syndContent.setValue("This article explains about creating RSS in Java using ROME library");
        
        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("Create RSS in Java using ROME");
        entry.setLink("https://www.blackslate.io/articles/create-rss-java-rome");
        entry.setPublishedDate(new Date(Instant.now().toEpochMilli()));
        entry.setDescription(syndContent);
        entry.setCategories(synedCatList);
        rssEntries.add(entry);
        
        feed.setEntries(rssEntries);
        
        //write to file
        Writer writer = new FileWriter("C:\\test\\rss.xml");
        SyndFeedOutput output = new SyndFeedOutput();
        output.output(feed, writer);
        writer.close();
	}
	
	
	
	
}
