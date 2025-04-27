package com.frimil.frimilapi.autenticacao;

import com.frimil.frimilapi.autenticacao.dto.LoginRequestDTO;
import com.frimil.frimilapi.autenticacao.dto.RegisterUserRequestDTO;
import com.frimil.frimilapi.autenticacao.dto.TokenResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
@AllArgsConstructor
public class AutenticacaoController implements AutenticacaoRecurso {

    private final AutenticacaoServico autenticacaoServico;


    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> loginUser(@RequestBody @Valid LoginRequestDTO dto){
        return ResponseEntity.ok(autenticacaoServico.loginUser(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> registerUser(@RequestBody @Valid RegisterUserRequestDTO dto){
        return ResponseEntity.ok(autenticacaoServico.registerUser(dto));
    }
}
