package com.jwt.token.tokencreation;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import com.jwt.token.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class Token {

	private String secret = "qwertyuiopkjjhgfdsazxcvdzdbnwery";

	public String tokenCreation(User user) {
		
		try {
			String jwt = Jwts.builder().header().add("id", user.getId())
					.add("issuedAt", new Date(System.currentTimeMillis()))
					.add("expiryAt", new Date((System.currentTimeMillis()) + 60)).and().claim("name", user.getName())
					.claim("email", user.getEmail()).claim("phoneNumber", user.getPhoneNumber())
					.claim("user roll", user.getUserRole()).signWith(getSigningKey()).compact();
//			System.out.println(Jwts.builder().signWith(getSigningKey()));

			return jwt;
		} catch (Exception e) {
			return e.toString();
		}
	}

	private Key getSigningKey() {

		byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
//		System.out.println(keyBytes);
//		System.out.println(Keys.hmacShaKeyFor(keyBytes));
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String tokenVerify(String token) {
		try {
		   Jws<Claims> j= Jwts.parser().verifyWith((SecretKey)getSigningKey()).build().parseSignedClaims(token);
//		   System.out.print(j.getPayload().getIssuer());
			return Jwts.parser().verifyWith((SecretKey) getSigningKey()).build().parseSignedClaims(token).toString();

		} catch (JwtException e) {

			return e.toString();
		}
	}
}

//		BuilderHeader jwt = Jwts.builder().header().add("id", user.getId()).add("name", user.getName());
//		
//		
//		
//		JwtBuilder builder = Jwts.builder();
//		
//		builder.audience().add("name").and();
////		builder.claim("name", user.getName()).claim("email", user.getEmail());
//		
////		return Jwts.builder()
////	    .audience().add("an-audience").and() // allows fluent chaining
////	    .subject("Joe").compact();
//		
////		System.currentTimeMillis()
////		builder.compact();
//		
//		return Jwts.builder().header().add("aHeaderName",user.getId()).toString();
////		Claims claims = Jwts.claims()
////                .setIssuer(user.getId().toString());
////		claims.put("name", user.getName());
////        claims.put("emailId", user.getEmail());
////        
////        return Jwts.builder()
////                .setClaims(claims)
////                .signWith(SignatureAlgorithm.HS512, key)
////                .compact();
