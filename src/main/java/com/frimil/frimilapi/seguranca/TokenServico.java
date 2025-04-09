package com.frimil.frimilapi.seguranca;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.frimil.frimilapi.comum.excecoes.TokenException;
import com.frimil.frimilapi.usuario.Usuario;
import com.frimil.frimilapi.usuario.UsuarioServico;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static java.util.Objects.nonNull;

@Slf4j
@Service
public class TokenServico {

    @Value("${jwt.secret.key}")
    private String jwtKey;
    private final UsuarioServico usuarioServico;

    public TokenServico(UsuarioServico usuarioServico){
        this.usuarioServico = usuarioServico;
    }
    public Algorithm getAlgorithm(){
        return Algorithm.HMAC256(jwtKey);
    }

    public String generateToken(Usuario usuario){
        try{
            return JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(generateExpirationInstant())
                    .sign(getAlgorithm());
        }catch (Exception e){
            log.error(" > TokenService.generateToken | Error to generate token: {}", e.getMessage());
            throw new TokenException("Erro enquanto gera o token de acesso");
        }
    }

    public boolean validateToken(String token){
        try {
            JWT.require(getAlgorithm())
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error(" > TokenService.validateToken | Invalid JWT token: {}", e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Error validating JWT token: {}", e.getMessage());
            return false;
        }
    }

    public String getEmailFromToken(String token){
        return JWT.require(getAlgorithm())
                .withIssuer("login-auth-api")
                .build()
                .verify(token)
                .getSubject();
    }

    public String getRoleFromToken(String token){
        return JWT.require(getAlgorithm())
                .withIssuer("login-auth-api")
                .build()
                .verify(token)
                .getClaim("role").toString();
    }

    public Usuario getUserFromRequest(HttpServletRequest request){

        String token = getTokenFromRequest(request);
        String email = this.getEmailFromToken(token);

        return usuarioServico.findOrThrow(email);
    }

    public static String getTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (nonNull(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public Instant generateExpirationInstant(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

}
