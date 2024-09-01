package br.com.gestao.tarefas.dto.TarefaDto;

import br.com.gestao.tarefas.model.Status;
import br.com.gestao.tarefas.model.Tarefa;

import java.time.LocalDate;

public record DetalhesTarefaDto(Long id, String titulo, String descricao, LocalDate datacConclusao, Status status, Long idUsuario) {

    public DetalhesTarefaDto(Tarefa tarefa){
        this (tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataConclusao(), tarefa.getStatus(), tarefa.getUsuario().getId());
    }
}
