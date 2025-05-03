package br.com.on.app.controller.swagger;

import br.com.on.app.entity.dto.PessoaInsertDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Pessoa", description = "APIs relacionadas a Pessoa")
public interface PessoaControllerSwagger {

    @Operation(summary = "Insere uma nova pessoa", description = "Insere uma nova pessoa no sistema")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Pessoa criada",
                        content =
                                @Content(
                                        mediaType = "application/json",
                                        schema = @Schema(implementation = PessoaInsertDTO.class))),
                @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            })
    ResponseEntity<PessoaInsertDTO> create(@RequestBody PessoaInsertDTO pessoaInsertDTO);
}
