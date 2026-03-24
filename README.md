# 🚀 Food Microservices API (Spring Boot & Spring Cloud)

Projeto desenvolvido com **Java + Spring Boot + Spring Cloud**, aplicando na prática conceitos de **arquitetura de microsserviços**, comunicação entre serviços e escalabilidade de aplicações distribuídas.

A aplicação simula um sistema de pedidos e pagamentos, onde os serviços se comunicam entre si de forma desacoplada, utilizando **Service Discovery, API Gateway e OpenFeign**.

---

## 🧠 Arquitetura do Sistema

A aplicação foi construída utilizando arquitetura de microsserviços, garantindo:

* 🔹 Desacoplamento entre serviços
* 🔹 Escalabilidade
* 🔹 Facilidade de manutenção
* 🔹 Independência de deploy

### 📊 Fluxo da aplicação

```text
Client → API Gateway → Microsserviços (Pedidos / Pagamentos)
                           ↓
                        Eureka Server
```

📌 O **Gateway** atua como ponto único de entrada
📌 O **Eureka** faz o registro e descoberta dos serviços
📌 Os microsserviços se comunicam entre si via **OpenFeign**

---

## 🧩 Microsserviços

O projeto é composto pelos seguintes serviços:

### 🔹 API Gateway

* Ponto único de acesso à aplicação
* Responsável por roteamento das requisições
* Balanceamento de carga entre instâncias

---

### 🔹 Eureka Server (Service Registry)

* Registro central dos microsserviços
* Permite descoberta dinâmica por nome
* Elimina dependência de IP/porta fixa

---

### 🔹 Serviço de Pedidos

* Gerenciamento de pedidos
* CRUD completo
* Controle de status do pedido

---

### 🔹 Serviço de Pagamentos

* Processamento de pagamentos
* Integração com serviço de pedidos
* Atualização automática do status do pedido

---

## 🔗 Comunicação entre serviços

A comunicação entre microsserviços é feita utilizando:

* **OpenFeign (Spring Cloud)** → chamadas HTTP entre serviços
* **Eureka Discovery** → localização dinâmica dos serviços

📌 Exemplo prático:
Após confirmar um pagamento, o serviço de pagamentos chama o serviço de pedidos para atualizar o status do pedido.

---

## ⚙️ Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Cloud
* Eureka Server
* Spring Cloud Gateway
* OpenFeign
* Spring Data JPA
* MySQL
* Flyway
* Lombok
* Maven

---

## 🔐 Boas Práticas Aplicadas

* ✔️ Arquitetura em camadas (Controller, Service, Repository)
* ✔️ Uso de DTOs para desacoplamento
* ✔️ Separação de responsabilidades
* ✔️ Validação de dados
* ✔️ Versionamento de banco com Flyway
* ✔️ Comunicação entre serviços desacoplada

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

* Java 17+
* Maven
* MySQL
* IntelliJ IDEA (recomendado)

---

### ▶️ Ordem de execução (IMPORTANTE)

1. **Eureka Server**
2. **Microsserviços (Pedidos e Pagamentos)**
3. **API Gateway**

---

## 🧪 Testando a API

Utilize:

* Postman
* Insomnia

Fluxo recomendado para testes:

1. Criar pedido
2. Realizar pagamento
3. Verificar atualização do status do pedido

---

## 📊 Banco de Dados

O projeto utiliza **Flyway** para controle de versão do banco.

Padrão:

```text
V<versao>__<descricao>.sql
```

---

## 📈 Diferenciais do Projeto

* 🔥 Arquitetura real de microsserviços
* 🔥 Service Discovery com Eureka
* 🔥 API Gateway centralizado
* 🔥 Comunicação entre serviços com Feign
* 🔥 Integração entre pagamentos e pedidos
* 🔥 Projeto organizado para escala

---

## 👨‍💻 Autor

**Vinicius de Miranda Melo**

* GitHub: https://github.com/vinimiiranda
* LinkedIn: https://www.linkedin.com/in/vinicius-miranda-melo

---

💡 Projeto desenvolvido com foco em aprendizado prático de **microsserviços com Spring Cloud**, simulando cenários reais de sistemas distribuídos.
