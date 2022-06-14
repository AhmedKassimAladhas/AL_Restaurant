package com.aladhas.ALrestaurant.sec;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.jdbc.Expectations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtiles {

	private Long TOKEN_VALIDITY = 604800L;
	private String TOKEN_SECRET = "ALRestaurant";

	public String GenerateToken(UserDetails userDetail) {
		Map<String, Object> clims = new HashMap<>();
		clims.put("sub", userDetail.getUsername());
		clims.put("created", new Date());

		return Jwts.builder().setClaims(clims).setExpiration(getExpirationDate())
				.signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();
	}

	public Date getExpirationDate() {
		return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
	}

	public String getUserNameFromToken(String token) {
		Claims claims = getClaims(token);
		return claims.getSubject();
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		String userName = getUserNameFromToken(token);

		return (userName.equals(userDetails.getUsername()) && !TokenExpired(token));
	}

	private boolean TokenExpired(String token) {
		Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	private Claims getClaims(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

}
