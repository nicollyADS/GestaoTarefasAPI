package br.com.gestao.tarefas.model;

import br.com.gestao.tarefas.dto.TarefaDto.CadastroTarefaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_status", nullable = false)
    private Status status = Status.PENDENTE;

    //relacionamentos

    //TAREFA USUARIO - MANY TO ONE
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;


    public Tarefa(CadastroTarefaDto dto){
        titulo = dto.titulo();
        descricao = dto.descricao();
        dataConclusao = dto.dataConclusao();
        status = dto.status() != null ? dto.status() : Status.PENDENTE;
    }

    public void atualizarInformacoesTarefa(CadastroTarefaDto dto){
        if(dto.titulo() != null )
            titulo = dto.titulo();
        if(dto.descricao() != null )
            descricao = dto.descricao();
        if(dto.dataConclusao() != null)
            dataConclusao = dto.dataConclusao();
        if(dto.status() != null)
            status = dto.status();
    }

}
