package com.blackslate.commons_lang;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassPathUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        test_StringUtils();
        test_NumberUtils();
        test_DateUtils();
        test_ArrayUtils();
        test_ExceptionUtils();
        
        test_ClassUtils();
        test_Validate();
        test_SystemUtils();
        test_Tuple();
        test_Locale();
    }
    
    
    public static void test_StringUtils() {
        String text = "Hello, Apache Commons!";
        
        // Check if a String is empty or blank
        System.out.println("Is text empty? " + StringUtils.isEmpty(text));
        
        // Reverse a String
        System.out.println("Reversed text: " + StringUtils.reverse(text));
        
        // Swap case of characters
        System.out.println("Swapped case: " + StringUtils.swapCase(text));
        
        // Count occurrences of a character
        System.out.println("Occurrences of 'e': " + StringUtils.countMatches(text, 'e'));
    }
    
    public static void test_NumberUtils() {
        String numberStr = "123";
        
        // Convert String to int, handling null and invalid input
        int number = NumberUtils.toInt(numberStr, 0);
        System.out.println("Parsed number: " + number);
        
        // Check if a String is a valid number
        System.out.println("Is 'abc' a number? " + NumberUtils.isCreatable("abc"));
        
        System.out.println("Max number "+ NumberUtils.max(10, 100, 20, 200));
    }
    
    public static void test_DateUtils() {
        Date now = new Date();
        
        // Add one day to the current date
        Date tomorrow = DateUtils.addDays(now, 1);
        System.out.println("Tomorrow's date: " + tomorrow);
        
        // Check if two dates are on the same day
        Date futureDate = DateUtils.addMonths(now, 2);
        System.out.println("Are the dates on the same day? " + DateUtils.isSameDay(now, futureDate));
        
    }
    
    public static void test_ArrayUtils() {
        String[] array1 = {"apple", "banana", "cherry"};
        String[] array2 = {"banana", "orange", "strawberry"};
        
        // Combine two arrays
        String[] combinedArray = ArrayUtils.addAll(array1, array2);
        System.out.println("Combined array: " + Arrays.toString(combinedArray));
        
        // Check if an array contains a certain element
        boolean containsBanana = ArrayUtils.contains(array1, "banana");
        System.out.println("Does array1 contain 'banana'? " + containsBanana);
        
        // Remove an element from an array
        String[] newArray = ArrayUtils.removeElement(array2, "orange");
        System.out.println("New array after removal: " + Arrays.toString(newArray));
    }
    
    public static void test_ExceptionUtils() {
        try {
            // Simulate a NullPointerException
            String nullString = null;
            nullString.length();
        } 
        catch (NullPointerException e) {
            // Print the stack trace
            System.out.println("Stack Trace:");
            System.out.println(ExceptionUtils.getStackTrace(e));
            
            System.out.println("Message: " + ExceptionUtils.getMessage(e));
            
            // Get the root cause of the exception
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            System.out.println("Root Cause: " + rootCause);            
        }
    }
    
    public static void test_ClassUtils() {
    	
    	ClassPathUtils.packageToPath("com.blackslate.commons_lang");
    	
    	try {
    	
	    	User user = ConstructorUtils.invokeConstructor(User.class);
	    	
	    	MethodUtils.invokeMethod(user, false, "setName", "Blackslate");
	    	
	    	Object obj = MethodUtils.invokeMethod(user, "getName");
	    	System.out.println(obj);        
    	}
    	catch(Exception exp) {
    		System.out.println(exp.getMessage());
    	}
    }
    
    public static void test_SystemUtils() {
    	
    	System.out.println(SystemUtils.getJavaHome()); 
    	
    	System.out.println(SystemUtils.getJavaHome()); 
    	
    	System.out.println(SystemUtils.getEnvironmentVariable("varialbe", "default")); 
    }
    
    public static void test_Validate() {
    	
    	int i = -1;
    	int val = 100;
    	String str = "hello";
    	
    	try {
    	
	    	Validate.isTrue(i < 10, "Should be greater than %d", 10);
	    	
	    	Validate.exclusiveBetween(1, 1000, val);
	    	
	    	Validate.notEmpty(str);
    	}
    	catch(Exception exp) {
    		System.out.println(exp.getMessage());
    	}
    }
    
    public static void test_Tuple() {
    	
    	String name = "John";
    	String country = "India"; 
    	int score = 92;
    	
    	
    	Triple<String, String, Integer> triplets = ImmutableTriple.of(name, country, score);
    	System.out.println(triplets.getLeft());
    	
    	System.out.println(triplets.getMiddle());
    	
    	System.out.println(triplets.getRight());
    }
    
    public static void test_Locale() {
    	
    	Locale locale[] = Locale.getAvailableLocales();
    	for (Locale l : locale) {
    		  System.out.println(l.getDisplayCountry() + " " + l.getDisplayLanguage());
    	}
    	
    	String lang[]  = Locale.getISOLanguages();
    	for (String l : lang) {
  		  System.out.println(l);
    	}
    	
    	String country[]  = Locale.getISOCountries();
    	for (String l : country) {
  		  System.out.println(l);
    	}    	
    	
    }
    
}
