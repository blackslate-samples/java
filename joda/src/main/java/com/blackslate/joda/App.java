package com.blackslate.joda;



import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Instant instant = Instant.now();
    	System.out.println(instant);
    	
    	DateTime dateTime = DateTime.now();
    	System.out.println(dateTime);
    	
    	DateTimeFormatter format = DateTimeFormat.forPattern("dd/mm/yy");
    	String dateString = format.print(dateTime);
    	System.out.println(dateString);
    	
    	DateTime londonTime = DateTime.now(DateTimeZone.forID("Europe/London"));
    	System.out.println(londonTime);
    	
    	LocalDateTime locaTime = LocalDateTime.now();
    	System.out.println(locaTime);
    }
}
