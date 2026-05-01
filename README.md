# Finance API

API REST para controle de gastos pessoais, permitindo o gerenciamento de receitas e despesas de forma simples e eficiente.

---

## Funcionalidades

* Cadastro de transações (receitas e despesas)
* Listagem de todas as transações
* Busca por ID
* Remoção de transações
* Cálculo automático de saldo
* Filtro por tipo (RECEITA / DESPESA)
* Filtro por período (data inicial e final)

---

## Regras de Negócio

* Transações podem ser do tipo:

  * `RECEITA`
  * `DESPESA`
* O saldo é calculado com base na soma das receitas menos as despesas
* Datas são obrigatórias para controle financeiro

---

## Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* H2 Database (ou outro banco relacional)
* Maven

---

## Estrutura do Projeto

```
controller → Camada de entrada (API REST)
service → Regras de negócio
repository → Acesso ao banco de dados
model → Entidades do sistema
dto → Objetos de transferência de dados
exception → Tratamento de erros
```

---

## 🔗 Endpoints Principais

| Método | Endpoint          | Descrição                 |
| ------ | ----------------- | ------------------------- |
| GET    | /transacoes       | Lista todas as transações |
| POST   | /transacoes       | Cria uma nova transação   |
| GET    | /transacoes/{id}  | Busca por ID              |
| DELETE | /transacoes/{id}  | Remove uma transação      |
| GET    | /transacoes/saldo | Retorna o saldo total     |

---

## Possíveis Melhorias

* Autenticação com JWT
* Dashboard com estatísticas
* Relatórios financeiros
* Integração com APIs bancárias
* Versão frontend (React ou mobile)

---

## Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento backend com Java e Spring Boot, incluindo:

* Arquitetura em camadas
* Criação de APIs REST
* Regras de negócio
* Boas práticas de organização de código

---

## Autor

Desenvolvido por **Luiz Paullo**

---
