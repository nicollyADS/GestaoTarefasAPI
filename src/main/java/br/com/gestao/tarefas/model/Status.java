package br.com.gestao.tarefas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="TB_GT_STATUS")
@Getter
@Setter
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status")
    @SequenceGenerator(name = "status", sequenceName = "seq_gt_status", allocationSize = 1)
    @Column(name="id_status")
    private long id;

    @Column(name="ds_status", nullable = false, length = 50)
    private String descricao;

    //relacionamentos

    //STATUS TAREFA - ONE TO ONE
    @OneToOne
    @JoinColumn(name = "id_tarefa", nullable = false)
    private Tarefa tarefa;

}
