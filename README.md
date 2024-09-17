# Nome do Projeto

Um sistema de gerenciamento de veículos que utiliza Spring Boot e Java.

## Requisitos

- **Java**: 21

## Configuração do Projeto

### Clonar o Repositório

Clone o repositório para o seu ambiente local usando o seguinte comando:

```bash
git clone https://github.com/fharuo/veiculos.git
```

## Banco de Dados

### Configurar Banco de Dados

Para acessar o console H2, abra o navegador e vá para:

```bash
http://localhost:8080/h2-console
```

Use as seguintes credenciais para se conectar:

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:

## Endpoints

### Endpoinds Disponíveis

Aqui estão alguns dos endpoints disponíveis na aplicação:

GET /veiculos: Listar todos os veículos.
POST /veiculos: Criar um novo veículo.
PUT /veiculos/{id}: Atualizar um veículo existente.
DELETE /veiculos/{id}: Excluir um veículo.
GET /veiculos?marca={marca}&ano={ano}&cor={cor}: Buscar veículos com base nos parâmetros fornecidos.

