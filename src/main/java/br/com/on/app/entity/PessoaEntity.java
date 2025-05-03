package br.com.on.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "tb_pes_pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_id", nullable = false)
    private Long id;

    @Column(name = "pes_nome", nullable = false)
    private String nome;

    @Column(name = "pes_email", nullable = false, unique = true)
    private String email;

    @Column(name = "pes_dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "pes_cpf", length = 14, unique = true)
    private String cpf;

    @Column(name = "pes_telefone", length = 20)
    private String telefone;

    @Column(name = "pes_endereco", columnDefinition = "TEXT")
    private String endereco;

    @Column(name = "pes_dt_criacao", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @Column(name = "pes_dt_atualizacao")
    private LocalDateTime atualizadoEm;

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }
}
