package br.com.on.app.service;

import br.com.on.app.component.PessoaComponent;
import br.com.on.app.entity.PessoaEntity;
import br.com.on.app.entity.dto.PessoaInsertDTO;
import br.com.on.app.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaComponent pessoaComponent;
    private PessoaMapper pessoaMapper;

    @Autowired
    public PessoaService(PessoaComponent pessoaComponent, PessoaMapper pessoaMapper) {
        this.pessoaComponent = pessoaComponent;
        this.pessoaMapper = pessoaMapper;
    }

    public PessoaInsertDTO incluirPessoa(PessoaInsertDTO pessoa) {
        PessoaEntity pessoaEntity = pessoaMapper.toEntity(pessoa);
        return pessoaMapper.toDTO(pessoaComponent.save(pessoaEntity));
    }
}
