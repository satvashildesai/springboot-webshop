//package com.practiceproject.webshop.security;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//
//@Component
//public class JwtTokenHelper {
//
//	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//	private String secret = "unknown";
//
////	Retrive username from jwt token
//	public String getUsernameFromToken(String token) {
//		return getClaimFromToken(token, Claims::getSubject);
//	}
//
////	Get expiration date from jwt token
//	public Date getExpirationDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getExpiration);
//	}
//
////	Get Claim from token
//	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.applay(claims);
//	}
//
////	For retrieveing any information from token we need secret key
//	private Claims getAllClaimsFromToken(String token) {
//		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//	}
//
////	Check if the token has expired
//	private Boolean isTokenExpired(String token) {
//		final Date expiration = getExpirationDateFromToken(token);
//		return expiration.before(new Date());
//	}
//
////	Generate token for user
//	public String generateToken(UserDetails userDetails) {
//		Map<String, Object> claims = new HashMap<String, Object>();
//		return doGenerateToken(claims, userDetails.getUsername());
//	}
//	
//	
////	Validate token
//}
