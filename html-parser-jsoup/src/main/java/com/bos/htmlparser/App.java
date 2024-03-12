package com.bos.htmlparser;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			new Parser().parse();
		} 
        catch (IOException e) {
			e.printStackTrace();
		}
    }
}
