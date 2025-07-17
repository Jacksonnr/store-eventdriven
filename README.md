
# 🧩 Event-Driven Store - Monorepo de Microsserviços

Repositório monolítico contendo os três microsserviços principais de uma aplicação e-commerce baseada em arquitetura orientada a eventos.

---

## 📌 Microsserviços

- **🛒 inventory-service**: gerenciamento de produtos e controle de estoque  
- **📦 order-service** *(em desenvolvimento)*: processamento de pedidos e status  
- **💳 payment-service** *(em desenvolvimento)*: gestão de pagamentos e confirmação de transações  

Cada serviço é isolado, com seu próprio banco de dados e comunicação futura via mensageria (Kafka ou RabbitMQ).

---

## ⚙️ Tecnologias Utilizadas

- Java 17 + Spring Boot 3
- Spring Web / Spring Data JPA
- PostgreSQL
- Docker / Docker Compose
- Lombok
- Bean Validation (Jakarta)
- Arquitetura orientada a eventos event-driven *(em breve)*
- Testes com JUnit + Mockito *(em breve)*
- Kafka ou RabbitMQ *(em breve)*

---

## 🧱 Arquitetura

- Separação por camadas: `controller`, `service`, `repository`, `dto`, `exception`, `entity`
- Princípios **SOLID** e **Clean Code**
- Cada microsserviço é independente e desacoplado
- Comunicação assíncrona baseada em eventos

---

## 🚀 Funcionalidades (por serviço)

### ✅ inventory-service
- Cadastro, listagem, atualização e exclusão de produtos
- Validações de integridade (ex: proibição de preço/quantidade <= 0)
- Persistência com PostgreSQL
- REST API funcional

### 🔄 order-service *(próximo)*
- Registro de pedidos com status
- Comunicação via eventos com inventário e pagamento

### 💸 payment-service *(próximo)*
- Simulação de pagamentos e notificações
- Comunicação via eventos com pedidos

---

## 🐳 Como rodar o projeto

```bash
docker-compose up -d
```

Verifique se as portas usadas por cada serviço estão livres.  
O serviço `inventory-service` roda em: [http://localhost:8080](http://localhost:8080)

---

## 📁 Estrutura do Monorepo

```
store-eventdriven/
│
├── inventory-service/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── exception/
│   ├── repository/
│   ├── service/
│   └── InventoryServiceApplication.java
│
├── order-service/         # (em breve)
├── payment-service/       # (em breve)
└── docker-compose.yml
```

---

## 📌 Próximos passos

- [ ] Implementação de Kafka/RabbitMQ
- [ ] Integração entre microsserviços
- [ ] Testes unitários com JUnit/Mockito
- [ ] Auditoria de eventos e logs estruturados
- [ ] Segurança com autenticação JWT

---

## 👨‍💻 Autor

**Jackson Reis**  
GitHub: [@Jacksonnr](https://github.com/Jacksonnr)
