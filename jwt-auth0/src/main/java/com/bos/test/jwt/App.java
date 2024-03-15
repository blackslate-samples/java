package com.bos.test.jwt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String token = JwtTest.generateToken();
        
        JwtTest.verifyToken(token);
        
        JwtTest.decodeToken(token);
    }
}
