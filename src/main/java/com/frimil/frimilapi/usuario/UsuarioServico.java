package com.frimil.frimilapi.usuario;

import com.frimil.frimilapi.autenticacao.dto.RegisterUserRequestDTO;
import com.frimil.frimilapi.cargo.CargoServico;
import com.frimil.frimilapi.comum.excecoes.ResourceAlreadyExistException;
import com.frimil.frimilapi.comum.excecoes.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final CargoServico cargoServico;

    public Usuario findOrThrow(String email){
        return usuarioRepositorio.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Usuário com o email %s não encontrado.", email)));
    }

    public Usuario createUser(RegisterUserRequestDTO dto, PasswordEncoder passwordEncoder){

        if(usuarioRepositorio.findByEmail(dto.email()).isPresent()){
            throw new ResourceAlreadyExistException("usuário ja cadastrado no sistema. Por favor fazer o login.");
        }

        Usuario usuario = new Usuario();
        usuario.setName(dto.name());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setTelefone(dto.telefone());
        usuario.setCargos(Collections.singleton(cargoServico.findOrCreate(dto.cargo().getNome())));

        return usuarioRepositorio.save(usuario);
    }
}
