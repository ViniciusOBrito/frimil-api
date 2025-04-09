package com.frimil.frimilapi.autenticacao;

import com.frimil.frimilapi.autenticacao.dto.LoginRequestDTO;
import com.frimil.frimilapi.autenticacao.dto.RegisterUserRequestDTO;
import com.frimil.frimilapi.autenticacao.dto.TokenResponseDTO;
import com.frimil.frimilapi.comum.excecoes.InvalidCredentialException;
import com.frimil.frimilapi.seguranca.TokenServico;
import com.frimil.frimilapi.usuario.Usuario;
import com.frimil.frimilapi.usuario.UsuarioServico;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class AutenticacaoServico {

    private final UsuarioServico usuarioServico;
    private final TokenServico tokenServico;
    private final PasswordEncoder passwordEncoder;

    public TokenResponseDTO loginUser(LoginRequestDTO dto){

        Usuario user = usuarioServico.findOrThrow(dto.email());

        if(passwordEncoder.matches(dto.senha(), user.getSenha())){
            String token = tokenServico.generateToken(user);
            Instant expireAt = tokenServico.generateExpirationInstant();
            return new TokenResponseDTO(token, expireAt.toString(), user.getName());
        }

        throw new InvalidCredentialException();
    }

    public TokenResponseDTO registerUser(RegisterUserRequestDTO dto){

        Usuario usuario = usuarioServico.createUser(dto, passwordEncoder);

        String token = tokenServico.generateToken(usuario);
        Instant expireAt = tokenServico.generateExpirationInstant();

        return new TokenResponseDTO(token, expireAt.toString(), usuario.getName());
    }
}
