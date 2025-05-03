package br.com.on.app.builders;

import br.com.on.app.entity.dto.PessoaInsertDTO;
import java.time.LocalDate;

public class PessoaBuilder {

    public static PessoaInsertDTO createPessoa() {
        return PessoaInsertDTO.builder()
                .nome("Teste")
                .cpf("12312312312")
                .email("teste@gmail.com")
                .dataNascimento(LocalDate.of(2000, 3, 25))
                .telefone("27 12345-6789")
                .endereco("Rua Teste")
                .build();
    }
}
