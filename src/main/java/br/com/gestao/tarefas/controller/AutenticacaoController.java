package br.com.gestao.tarefas.controller;

import br.com.gestao.tarefas.dto.autenticacaoDto.AutenticacaoDto;
import br.com.gestao.tarefas.dto.autenticacaoDto.TokenDto;
import br.com.gestao.tarefas.model.Usuario;
import br.com.gestao.tarefas.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("login")
    public ResponseEntity<TokenDto> login(
            @RequestBody @Valid AutenticacaoDto dto){
        var usuario = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var authenticate = authenticationManager.authenticate(usuario);
        var token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenDto(token));
    }

}
