
# Todo Management API 🚀

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15+-blue)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A robust REST API for managing todo items built with Spring Boot, JPA, and PostgreSQL.


## Features ✨
- ✅ CRUD operations for todo items
- 🔍 Filter todos by status (To do, In progress, Done)
- 🔒 Role-based access control (Public/Admin endpoints)
- 📝 Comprehensive input validation
- 📚 Auto-generated Swagger documentation
- 🧪 Unit and integration tests

## Tech Stack 💻
- **Backend**: Java 17, Spring Boot 3.4.3
- **Database**: PostgreSQL 15+
- **API Documentation**: Swagger/OpenAPI 3.0
- **Build Tool**: Maven 3.8+
- **Validation**: Hibernate Validator

## Prerequisites 📦
- JDK 17 installed
- PostgreSQL 15+ running
- Maven 3.8+
- IDE (IntelliJ, VSCode, etc.)

## Installation 🛠️
1. Clone the repository:
   ```bash
   git@github.com:belviPouadjeu/Todo-Management-API.git
   cd Todo-Management-API

## Build the project:

```bash
mvn clean install
```

## Configuration ⚙️
Edit `src/main/resources/application.properties`:

```properties
# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=hels
spring.datasource.password=hels
spring.jpa.hibernate.ddl-auto=update

# Swagger
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
```

## API Documentation 📚
Interactive API documentation available at:
[Swagger UI](http://localhost:8082/swagger-ui.html)

### Endpoints 🌐
| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| GET | `/api/public/todos` | Public | Get all todos |
| POST | `/api/public/todos` | Public | Create new todo |
| GET | `/api/public/todos/status` | Public | Filter todos by status |
| PUT | `/api/admin/todos/{id}` | Admin | Update todo |
| DELETE | `/api/admin/todos/{id}` | Admin | Delete todo |

## Examples 💡
### Create Todo:

```bash
curl -X POST "http://localhost:8081/api/public/todos" \
-H "Content-Type: application/json" \
-d '{
  "title": "Complete API documentation",
  "description": "Write comprehensive docs for all endpoints",
  "status": "To do"
}'
```

### Get Todos by Status:

```bash
curl "http://localhost:8082/api/public/todos/status?status=In%20progress"
```

## Testing 🧪
### Run unit tests:

```bash
mvn test
```

## Json file documentation : 
`http://localhost:8081/v3/api-docs`

### Run integration tests (requires test DB):

```bash
mvn verify -Pintegration-test
```

## Deployment 🚀
### Build executable JAR:

```bash
mvn clean package
```

### Run application:

```bash
java -jar target/todo-0.0.1-SNAPSHOT.jar
```



