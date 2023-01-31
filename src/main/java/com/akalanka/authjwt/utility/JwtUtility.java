package com.akalanka.authjwt.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtUtility implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private String secret = "secret";

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String getFirstNameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }
}
