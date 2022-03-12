package com.metsoft.students.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;


@Service
public class TokenManager {
	
	private static final int expirationTime=5*60*1000;
	Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);
	public String generateToken(String username){
		
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis()+expirationTime))
				.setIssuer("Met")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(key)
				.compact();
	}
	public boolean tokenValidate(String token){
		if(checkExpirationTime(token) && getUsernameFromToken(token)!=null) {
			return true;
		}
		return false;
	}
	public String getUsernameFromToken(String token) {
		Claims claims =getClaims(token);
		return claims.getSubject();
	}
	public boolean checkExpirationTime(String token) {
		Claims claims=getClaims(token);
		return claims.getExpiration().after(new Date(System.currentTimeMillis()));
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}
	
}
