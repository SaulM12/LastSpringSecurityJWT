package com.souldev.security.security.jwt;

import java.util.Date;

import com.souldev.security.security.entities.MainUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;



@Component
public class JwtProvider {
    //Logger para mostrar los errores
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    //Clave para verificar el token
    @Value("${jwt.secret}")
    private String secret;

    //Tiempo base de expiración
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
      
        UserDetails mainUser = (UserDetails) authentication.getPrincipal();
        logger.error(mainUser.getUsername());
        return Jwts.builder().setSubject(mainUser.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime() + expiration *1000))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
    }
    //Creamos una función que permita obtener el nombre de usuario con el token
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    //Creamos una función que permita validar nuestro token con la firma secreta
    //Controlamos cualquier error que pueda existir con el token

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }
}
