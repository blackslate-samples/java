package com.blackslate.bloomfilter;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	UserIdFilter userIdFilter = new UserIdFilter();
    	
    	List<String> data = DataLoader.load();
    	data.forEach(item -> userIdFilter.addUser(item));
    	
    	String testUserIds[] = new String[] {
    			"abcd",
    			"charles",
    			"ganesh",
    			"muthu",
    			"jj",
    			"yy"
    	};
    	
    	for (String userId : testUserIds) {
    		boolean available = userIdFilter.exists(userId);
    		String message = String.format("%s is %s", userId, available ? "available" : "not available");
    		System.out.println(message);
		}
    	
    }
}


