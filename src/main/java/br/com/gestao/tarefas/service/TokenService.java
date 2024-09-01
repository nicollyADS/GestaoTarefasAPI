package br.com.gestao.tarefas.service;

import br.com.gestao.tarefas.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${password.token}")
    private String senhaToken;

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Não foi possível validar o TokenJWT");
        }
    }

    public String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.create()
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(Instant.now().plus(Duration.ofMinutes(30)))
                    .sign(algorithm);
        } catch(JWTCreationException e){
            throw new RuntimeException("Não foi possível criar o token JWT");
        }
    }
}
