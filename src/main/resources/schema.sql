-- Criação da tabela Marca
CREATE TABLE MARCA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Criação da tabela Veiculo
CREATE TABLE VEICULO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    veiculo VARCHAR(255) NOT NULL,
    marca_id BIGINT,
    ano INTEGER,
    descricao TEXT,
    vendido BOOLEAN,
    created TIMESTAMP,
    updated TIMESTAMP,
    CONSTRAINT fk_marca FOREIGN KEY (marca_id) REFERENCES MARCA(id)
);
