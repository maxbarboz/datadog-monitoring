package br.com.on.app.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaInsertDTO {

    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(max = 255, message = "O nome não pode ter mais de 255 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail não pode ser vazio.")
    @Size(max = 255, message = "O e-mail não pode ter mais de 255 caracteres.")
    private String email;

    @NotNull(message = "A data de nascimento não pode ser nula.") private LocalDate dataNascimento;

    @Size(max = 14, message = "O CPF deve ter no máximo 14 caracteres.")
    private String cpf;

    @Size(max = 20, message = "O telefone não pode ter mais de 20 caracteres.")
    private String telefone;

    @Size(max = 500, message = "O endereço não pode ter mais de 500 caracteres.")
    private String endereco;
}
