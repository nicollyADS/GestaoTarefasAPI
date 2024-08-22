package br.com.gestao.tarefas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Entity
@Table(name="TB_GT_TAREFA")
@Getter
@Setter
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarefa")
    @SequenceGenerator(name = "tarefa", sequenceName = "seq_gt_tarefa", allocationSize = 1)
    @Column(name="id_tarefa")
    private Long id;

    @Column(name="ds_titulo", nullable = false, length = 70)
    private String titulo;

    @Column(name="ds_tarefa", nullable = false, length = 250)
    private String descricao;

    @Column(name="dt_conclusao", nullable = false)
    private LocalDate dataConclusao;

    //relacionamentos

    //TAREFA USUARIO - MANY TO ONE

    //TAREFA STATUS - ONE TO ONE

}
