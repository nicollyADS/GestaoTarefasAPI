package br.com.gestao.tarefas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TB_GT_USUARIO")
@Getter @Setter
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @SequenceGenerator(name = "usuario", sequenceName = "seq_gt_usuario", allocationSize = 1)
    @Column(name="id_usuario")
    private Long id;

    @Column(name="nm_usuario", nullable = false, length = 100)
    private String nome;

    @Column(name="ds_email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name="ds_senha", nullable = false, length = 70)
    private String senha;

    //relacionamentos

    //USUARIO TAREFA - ONE TO MANY
    @OneToMany(mappedBy = "usuario")
    private List<Tarefa> tarefas;


    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //User Details
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
