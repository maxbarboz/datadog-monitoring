package br.com.on.app.mapper;

import br.com.on.app.entity.PessoaEntity;
import br.com.on.app.entity.dto.PessoaInsertDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaInsertDTO toDTO(PessoaEntity pessoa);

    PessoaEntity toEntity(PessoaInsertDTO pessoa);
}
