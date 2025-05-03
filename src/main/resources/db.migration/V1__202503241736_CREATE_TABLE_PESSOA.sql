CREATE TABLE tb_pes_pessoa (
    pes_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Identificador único da pessoa',
    pes_nome VARCHAR(255) NOT NULL COMMENT 'Nome completo da pessoa',
    pes_email VARCHAR(255) UNIQUE NOT NULL COMMENT 'Endereço de e-mail da pessoa',
    pes_dt_nascimento DATE COMMENT 'Data de nascimento da pessoa',
    pes_cpf VARCHAR(14) UNIQUE COMMENT 'Número do CPF da pessoa (formato: XXX.XXX.XXX-XX)',
    pes_telefone VARCHAR(20) COMMENT 'Número de telefone da pessoa',
    pes_endereco TEXT COMMENT 'Endereço completo da pessoa',
    pes_dt_criacao TIMESTAMP COMMENT 'Data e hora da criação do registro',
    pes_dt_atualizacao TIMESTAMP COMMENT 'Data e hora da última atualização do registro'
) COMMENT = 'Tabela que armazena informações sobre pessoas';