package br.com.on.app.component;

import br.com.on.app.entity.PessoaEntity;
import br.com.on.app.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaComponent {

    private PessoaRepository repository;

    @Autowired
    public PessoaComponent(PessoaRepository pessoaRepository) {
        this.repository = pessoaRepository;
    }

    public PessoaEntity save(PessoaEntity pessoaEntity) {
        return repository.save(pessoaEntity);
    }
}
