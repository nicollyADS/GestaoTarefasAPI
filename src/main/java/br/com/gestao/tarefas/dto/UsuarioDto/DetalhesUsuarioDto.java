package br.com.gestao.tarefas.dto.UsuarioDto;

import br.com.gestao.tarefas.model.Usuario;

public record DetalhesUsuarioDto(Long id, String nome) {

    public DetalhesUsuarioDto(Usuario usuario){
        this(usuario.getId(), usuario.getNome());
    }

}
