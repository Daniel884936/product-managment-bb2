package com.productmanagment.productmanagment.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import io.jsonwebtoken.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static com.productmanagment.productmanagment.utils.ApiConstants.*;

public class TokenProvider {

    private final static Logger logger = LoggerFactory.getLogger(TokenProvider.class);


    public static String generateToken(Authentication authentication){
        final String authorities = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setIssuer(ISSUER_TOKEN)
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .compact();
    }


    public static boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("malformed token");
        }catch (UnsupportedJwtException e){
            logger.error("unsupported token");
        }catch (ExpiredJwtException e){
            logger.error("expired token");
        }catch (IllegalArgumentException e){
            logger.error("empty token");
        }catch (SignatureException e){
            logger.error("fail in signature");
        }
        return false;
    }

    public static String getUsername(final String token){
        final JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);
        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }
}
