package com.blackslate.bloomfilter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataLoader {

	public static List<String> load() {
		
		String path = "YOUR-PATH";
		
		List<String> results = List.of();
		
		try {
			results = Files.readAllLines(Path.of(path));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return results; 
	}
	
}
