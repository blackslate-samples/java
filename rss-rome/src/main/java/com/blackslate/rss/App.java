package com.blackslate.rss;

import java.io.IOException;

import com.rometools.rome.io.FeedException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			
        	RssService rssService = new RssService();
        	
        	rssService.writeRssXml();
        	
        	rssService.readRssXml();
		
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
