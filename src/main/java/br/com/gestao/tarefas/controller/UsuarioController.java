package br.com.gestao.tarefas.controller;

import br.com.gestao.tarefas.dto.UsuarioDto.CadastroUsuarioDto;
import br.com.gestao.tarefas.dto.UsuarioDto.DetalhesUsuarioDto;
import br.com.gestao.tarefas.model.Usuario;
import br.com.gestao.tarefas.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto dto,
                                                   UriComponentsBuilder uri){
        var usuario = new Usuario(dto.nome(), dto.email(), passwordEncoder.encode(dto.senha()));
        usuarioRepository.save(usuario);
        var uriBuilder = uri.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uriBuilder).body(new DetalhesUsuarioDto(usuario));
    }
}
