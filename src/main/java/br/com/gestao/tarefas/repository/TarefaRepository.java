package br.com.gestao.tarefas.repository;

import br.com.gestao.tarefas.model.Tarefa;
import br.com.gestao.tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long > {
}
