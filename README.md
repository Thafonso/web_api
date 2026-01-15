📦 Product API – Spring Boot

API REST desenvolvida em Java com Spring Boot, utilizando Spring MVC (Servlet), Spring Data, validações com Jakarta Validation e arquitetura em camadas bem definida.

O projeto fornece endpoints para gerenciamento de produtos, seguindo boas práticas de organização, separação de responsabilidades e uso de DTOs.

---

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web (Servlet / Spring MVC)

Spring Data JPA

Jakarta Bean Validation

Lombok

Maven

H2 / PostgreSQL (configurável)

---

🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, organizada da seguinte forma:

src/main/java
└── org.github.thafonso.project_api_springboot
    ├── domain
    │   ├── entity
    │   │   └── Product
    │   └── repository
    │       └── ProductRepository
    │
    ├── service
    │   ├── ProductService
    │   └── NotFoundException
    │
    ├── web
    │   ├── controller
    │   │   └── ProductController
    │   ├── dto
    │   │   ├── ProductRequest
    │   │   └── ProductResponse
    │   └── handler
    │
    └── ApplicationRunner

---

📌 Responsabilidade das Camadas
🔹 domain

Contém as regras centrais do domínio da aplicação.

entity

Product → Entidade JPA que representa o produto no banco de dados.

repository

ProductRepository → Interface de persistência usando Spring Data JPA.

---

🔹 service

Camada responsável pela regra de negócio.

ProductService

Orquestra as operações de CRUD

Realiza validações de negócio

NotFoundException

Exceção customizada para recursos não encontrados

---

🔹 web

Camada responsável pela comunicação HTTP.

controller

ProductController → Exposição dos endpoints REST

dto

ProductRequest → DTO de entrada

ProductResponse → DTO de saída

handler

Espaço reservado para tratamento global de exceções (@ControllerAdvice)

---

🔗 Endpoints da API
📄 Listar produtos (paginado)
GET /products


Parâmetros opcionais:

page

size

sort (default: createdAt)

🔍 Buscar produto por ID
GET /products/{id}

➕ Criar produto
POST /products


Body (JSON):

{
  "name": "Notebook",
  "price": 4500.00,
  "description": "Notebook para trabalhar"
}


✔️ Validação automática com @Valid
✔️ Retorna 201 Created
✔️ Header Location com o recurso criado

🗑️ Deletar produto
DELETE /products/{id}


✔️ Retorna 204 No Content
