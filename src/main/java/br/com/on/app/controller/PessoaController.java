package br.com.on.app.controller;

import br.com.on.app.controller.swagger.PessoaControllerSwagger;
import br.com.on.app.entity.dto.PessoaInsertDTO;
import br.com.on.app.service.PessoaService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
@Log4j2
@CrossOrigin
public class PessoaController implements PessoaControllerSwagger {

    private final PessoaService service;

    @Autowired
    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PessoaInsertDTO> create(@Valid @RequestBody PessoaInsertDTO pessoaInsertDTO) {
        log.info("Iniciando processo de inclusão de um registro de Pessoa");
        PessoaInsertDTO pessoaPersistida = service.incluirPessoa(pessoaInsertDTO);
        log.info("Processo de inclusão finalizado.");
        return ResponseEntity.ok(pessoaPersistida);
    }
}
