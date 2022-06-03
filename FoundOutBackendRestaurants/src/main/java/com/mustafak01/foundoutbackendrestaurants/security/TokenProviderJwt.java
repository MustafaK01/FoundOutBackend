package com.mustafak01.foundoutbackendrestaurants.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class TokenProviderJwt {

    @Value("${app.secret.key}")
    private String SECRET_KEY;

    @Value("${app.expires.in}")
    private Long EXPIRES_IN;

    //This method will generate token
    public String generateToken(Authentication authentication){
        UserDetailsJwt userDetailsJwt = (UserDetailsJwt) authentication.getPrincipal();
        Date expirationDate= new Date(System.currentTimeMillis() + EXPIRES_IN);
        return Jwts.builder().setSubject(userDetailsJwt.getUsername())
                .setIssuedAt(new Date()).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY).compact();
    }

    //This method will get the userName from token
    public String getUserNameFromJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    //This method will validate the token
    boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return !tokenExpired(token);
        }catch (SignatureException e){
            log.info( "" + e );
            return false;
        }catch (MalformedJwtException e){
            log.info( "" + e );
            return false;
        }catch (ExpiredJwtException e){
            log.info( "" + e );
            return false;
        }
    }
    public Long expirationDate(String token){
        Date expirate = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expirate.getTime();
    }
    private boolean tokenExpired(String token) {
        Date expirate = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
                .getBody()
                .getExpiration();
        //if not expited yet, will return false;
        //if expired will return true;
        return expirate.before(new Date());
    }
}
