package br.com.gestao.tarefas.repository;

import br.com.gestao.tarefas.model.Status;
import br.com.gestao.tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long > {
}
