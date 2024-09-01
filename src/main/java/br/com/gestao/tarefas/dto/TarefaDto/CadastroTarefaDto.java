package br.com.gestao.tarefas.dto.TarefaDto;

import br.com.gestao.tarefas.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroTarefaDto(

        @Size(max = 70, message = "a quantidade máxima é de 70 caracteres")
        @NotBlank(message = "O título não pode estar em branco")
        String titulo,

        @Size(max = 250, message="a quantidade máxima é de 250 caracteres")
        @NotBlank(message = "A descricao não pode estar em branco")
        String descricao,

        @NotNull(message = "A data de conclusão não pode ser nula")
        LocalDate dataConclusao,

        Status status,

        @NotNull(message = "O id do usuario não pode ser nulo, informe um id existente")
        Long idUsuario
)

{
}
