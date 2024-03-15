package com.bos.test.jwt;

import java.util.Base64;
import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtTest {
	
	static final String SECRET_KEY = "your-secret-key";

	public static String generateToken() {
		
		Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR,  1);
		
		String token = JWT.create()
						  	 .withSubject("Blackslate")
						  	 .withIssuer("Blackslate")
							 .withClaim("Name", "Rahul")
							 .withClaim("Role", "Admin")
							 .withClaim("UserId", "1010101")
							 .withExpiresAt(cal.getTime())
							 .sign(algorithm);
		
		System.out.println(token);
		
		return token;
	}
	
	public static void verifyToken(String token) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR,  -1);
		
		Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);

		JWTVerifier verifier = JWT.require(algorithm)
								 .acceptExpiresAt(120)
								 .build();
		
		try {
			DecodedJWT decodedJwt = verifier.verify(token);
			System.out.println(decodedJwt.getClaim("Name").asString());
			System.out.println(decodedJwt.getClaim("UserId").asString());
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
			
	}
	
	public static void decodeToken(String token) {
		
		String toks[] = token.split("\\.");
		for(int i=0; i < toks.length - 1; i++) {
			System.out.println(new String(Base64.getDecoder().decode(toks[i])));
		}	
	}
	
	
	
}
