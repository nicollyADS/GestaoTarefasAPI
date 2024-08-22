package br.com.gestao.tarefas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_GT_USUARIO")
@Getter @Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @SequenceGenerator(name = "usuario", sequenceName = "seq_gt_usuario", allocationSize = 1)
    @Column(name="id_usuario")
    private Long id;

    @Column(name="nm_usuario", nullable = false, length = 100)
    private String nome;

    @Column(name="ds_email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name="ds_senha", nullable = false, length = 20)
    private String senha;

    //relacionamentos

    //USUARIO TAREFA - ONE TO MANY
}
