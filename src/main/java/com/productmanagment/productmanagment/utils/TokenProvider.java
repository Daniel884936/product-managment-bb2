package com.productmanagment.productmanagment.utils;

import com.productmanagment.productmanagment.models.PrincipalUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import io.jsonwebtoken.*;
import java.util.Date;
import java.util.stream.Collectors;

import static com.productmanagment.productmanagment.utils.ApiConstants.*;

public class TokenProvider {

    private final static Logger logger = LoggerFactory.getLogger(TokenProvider.class);
    private static Date tokenExpiration;


    public static String generateToken(Authentication authentication){
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(principalUser.getUsername())
                .claim(AUTHORITIES_KEY, authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(generaExpirationToken())
                .signWith(SignatureAlgorithm.HS512, SIGNING_KEY)
                .compact();
    }

    private static Date generaExpirationToken(){
        tokenExpiration = new Date(new Date().getTime() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000);
        return tokenExpiration;
    }

    public static Date getExpirationToken(){
        return tokenExpiration;
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
