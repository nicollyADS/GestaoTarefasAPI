package br.com.gestao.tarefas.dto.UsuarioDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioDto(

        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 100, message = "a quantidade máxima é de 100 caracteres")
        String nome,

        @Size(max = 100, message = "a quantidade máxima é de 100 caracteres")
        @NotBlank(message = "O email não pode estar em branco")
        @Email(message = "O email deve ser válido")
        String email,

        @Size(max = 70, message = "a quantidade máxima é de 20 caracteres")
        @NotBlank(message = "A senha não pode estar em branco")
        String senha) {
}
