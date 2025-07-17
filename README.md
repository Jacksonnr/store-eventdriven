# 🛒 Inventory Service - Event-Driven Store

Microsserviço responsável pela gestão de produtos e controle de estoque, desenvolvido como parte de um sistema orientado a eventos para uma aplicação de e-commerce.

---

## 📦 Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose
- Lombok
- Bean Validation (Jakarta)
- Event-driven architecture *(em breve com Kafka ou RabbitMQ)*

---

## 🚀 Funcionalidades

- ✅ Cadastro de produtos
- ✅ Consulta de produtos por ID ou listagem
- ✅ Atualização e exclusão de produtos
- ✅ Validações de integridade dos dados
- 🔄 Comunicação futura via mensageria com outros microsserviços

---

## 🧱 Arquitetura

Este serviço faz parte de um ecossistema baseado em microsserviços. Cada serviço possui seu próprio banco de dados e comunica-se por meio de eventos (mensageria). A arquitetura segue os princípios de:

- Separação por camadas (`controller`, `service`, `repository`, `dto`, `exception`)
- Princípios SOLID
- Clean Code

---

## ⚙️ Configuração

### Variáveis de ambiente (application.properties)

```properties
spring.application.name=inventory-service
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5434/DB_SERVICE
spring.datasource.username=admin
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## 🐳 Subindo com Docker Compose

docker-compose up -d

Certifique-se de que a porta 5434 do banco de dados esteja livre.

Exemplo de requisição:
json

POST /products
{
  "name": "Monitor Gamer",
  "price": 1499.99,
  "amount": 20
}


📁 Estrutura de Pastas
inventory-service/
│
├── controller/
├── dto/
├── entity/
├── exception/
├── repository/
├── service/
└── InventoryServiceApplication.java


📌 Próximos passos
 Integração com Kafka/RabbitMQ

 Testes unitários com JUnit e Mockito

 Integração com microsserviço de pedidos

 Validações assíncronas e auditoria de eventos

👨‍💻 Autor
Jackson Reis
GitHub - @Jacksonnr
