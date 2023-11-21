package com.blackslate.serializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.eclipse.serializer.Serializer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	testSerialization();
    	
    	testEclipseSerialization();
    	
    	testEclipseDeserialization();
    }
    
    public static void testSerialization() {
    	
    	String filePath = "C:\\work\\test.out";
    	
    	User user = new User("editor", "editor@example.com");
    	UserNew userNew = new UserNew("editor", "editor@example.com");
    	
    	ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filePath));
			out.writeObject(user);
			out.writeObject(userNew);
	    	out.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}   	
    }
    
    public static void testEclipseSerialization() {
    	
    	String filePath = "C:\\work\\test.out";
    	
    	User user = new User("editor", "editor@example.com");
    	UserNew userNew = new UserNew("editor", "editor@example.com");
    	
    	ObjectOutputStream out;
		try {
			
			Serializer<byte[]> serializer = Serializer.Bytes();
			
			byte[] data  = serializer.serialize(user);
			byte[] data1 = serializer.serialize(userNew);
			
			out = new ObjectOutputStream(new FileOutputStream(filePath));
			out.write(data);
			out.write(data1);
	    	out.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}   	
    }
    
    public static void testEclipseDeserialization() {
    	
    	UserNew userNew = new UserNew("editor", "editor@example.com");
    	
    	Serializer<byte[]> serializer = Serializer.Bytes();
		byte[] data = serializer.serialize(userNew);
    	
		UserNew user = serializer.deserialize(data);
		System.out.println(user.getEmail());
		
    }
    
    
}
