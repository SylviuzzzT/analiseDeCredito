# Sistema de Análise de Crédito

Este é um projeto pessoal desenvolvido com o objetivo de praticar a construção de uma aplicação Spring Boot com foco em regras de negócio. Apesar de conter operações básicas de CRUD, o foco principal está na **análise de crédito**, simulando como um sistema real poderia avaliar o perfil financeiro de uma pessoa.

## 💡 Objetivo do Projeto

A ideia aqui não é apenas cadastrar clientes, mas também **analisar o score de crédito** com base no histórico financeiro, tipo de renda e dados pessoais. A proposta foi aplicar conceitos como separação de responsabilidades, uso de DTOs, regras de negócio isoladas e organização por camadas.

## 🔍 Funcionalidades

- Cadastro de pessoas com dados pessoais, renda e histórico financeiro
- Análise automática de crédito no momento do cadastro
- Score calculado com base em:
    - Modalidade de renda (ATIVA / PASSIVA)
    - Valor da renda
    - Dívidas em aberto e vencimento das dívidas
- Retorno da análise com uma recomendação final (APROVADO / REPROVADO / EM ANÁLISE)

## 🧱 Tecnologias e Ferramentas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## 📁 Organização do Projeto

O projeto está dividido em pacotes por responsabilidade:

- `controller`: endpoints REST
- `controller.dto`: objetos de entrada e saída
- `domain.model`: entidades e enums de negócio
- `service`: regras de negócio (ex: cálculo de score)
- `repository`: interfaces com o banco
- `infrastructure.mapper`: conversões entre entidades, modelos e DTOs
- `infrastructure.persistence`: mapeamento JPA das entidades

## 🛠 Melhorias Futuras

- Implementar autenticação com JWT
- Documentar a API com Swagger
- Adicionar testes unitários
- Melhorar a cobertura de regras de negócio

## ✍️ Sobre

Esse projeto foi criado com o objetivo de praticar e mostrar meu avanço como desenvolvedor backend. Não é um sistema comercial, mas sim um estudo bem estruturado que simula problemas reais de análise de crédito.

---


