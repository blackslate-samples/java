package com.blackslate.lombok;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.blackslate.lombok.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        
        User user = new User();
        user.setName("dd");
        user.setEmail("aa@dd.com");
        System.out.print(user.getName());
        
        User user2 = User.builder()
        				 .name("builder")
        				 .email("aa@aa.com")
        				 .build();
        System.out.print(user2.getName());
    }
}
