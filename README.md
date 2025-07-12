```markdown
# 🛍️ Spring Boot Product API

This is a simple RESTful API built with **Spring Boot**, **PostgreSQL**, and **Redis**.  
It demonstrates how to cache database queries using Redis to improve performance.

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot 3.x
- PostgreSQL (via Docker)
- Redis (via Docker)
- Spring Data JPA
- Spring Cache with Redis
- Docker & Docker Compose

---

## 📦 Features

- Create a new product
- Get all products
- Data persistence using PostgreSQL
- Caching of product list using Redis
- TTL-based cache expiration
- Easy local development with Docker Compose

---

## 🗂️ Project Structure

```

springboot-product-api/
├── src/main/java/com/example/demo/
│   ├── product/
│   │   ├── Product.java
│   │   ├── ProductRepository.java
│   │   ├── ProductService.java
│   │   ├── ProductServiceImpl.java
│   │   └── ProductController.java
│   └── config/
│       └── CacheConfig.java
├── src/main/resources/
│   └── application.yml
├── docker-compose.yml
├── pom.xml
└── README.md

````

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/jiporCK/redis-db-api.git
cd springboot-product-api
````

---

### 2. Start PostgreSQL and Redis with Docker

Make sure Docker is running, then:

```bash
docker-compose up -d
```

This will start:

* **PostgreSQL** at `localhost:5432`
* **Redis** at `localhost:6379`

> You can verify with `docker ps`

---

### 3. Run the Spring Boot Application

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or build the JAR and run it:

```bash
./mvnw clean install
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

App will run on:
📍 `http://localhost:8080`

---

## 🌐 API Endpoints

### `GET /api/products`

* Description: Get all products
* Caches the result using Redis

### `POST /api/products`

* Description: Create a new product
* Request Body:

```json
{
  "name": "Desk Lamp",
  "price": 49.99,
  "qty": 5
}
```

* Returns: The saved product

---

## ⚙️ Configuration

### `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/products
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  data:
    redis:
      host: localhost
      port: 6379
  cache:
    type: redis
```

---

### `docker-compose.yml`

```yaml
version: "3.8"
services:
  postgres:
    image: postgres:15
    container_name: product-postgres
    ports:
      - "5432:5432"
    environment:
      POSTGRES_DB: products
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    volumes:
      - pgdata:/var/lib/postgresql/data

  redis:
    image: redis:7
    container_name: product-redis
    ports:
      - "6379:6379"

volumes:
  pgdata:
```

---

## 🧪 Testing with Postman

### Add Product

```
POST http://localhost:8080/api/products
```

#### Body (JSON)

```json
{
  "name": "Ergonomic Chair",
  "price": 129.99,
  "qty": 10
}
```

### Get All Products

```
GET http://localhost:8080/api/products
```

---

## 🧠 Notes

* Redis is used via Spring Cache (`@Cacheable`)
* TTL (Time-To-Live) for cache entries is set in `CacheConfig`
* Product data is stored in PostgreSQL

---

## 🪪 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

Made with ❤️ by Sreng Chipor

```

