Blog Platform API
A RESTful blog platform built with Spring Boot 3.4, featuring JWT authentication, post management, and content organization via categories and tags.
Tech Stack
Java 21 • Spring Boot 3.4 • Spring Security • PostgreSQL • JWT • MapStruct • Lombok • Docker
Quick Start
bash# Start PostgreSQL
docker-compose up -d

# Build and run
./mvnw spring-boot:run
Configure src/main/resources/application.properties:
propertiesspring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=changemeinprod!
jwt.secret=your-256-bit-secret-key-here-make-it-at-least-32-bytes-long
```

**Default Login:** `user@test.com` / `password`

API runs at `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/v1/auth/login` - Login and receive JWT token

### Posts
- `GET /api/v1/posts` - List posts (supports `?categoryId=` and `?tagId=`)
- `GET /api/v1/posts/{id}` - Get post
- `GET /api/v1/posts/drafts` - List drafts (auth required)
- `POST /api/v1/posts` - Create post (auth required)
- `PUT /api/v1/posts/{id}` - Update post (auth required)
- `DELETE /api/v1/posts/{id}` - Delete post (auth required)

### Categories
- `GET /api/v1/categories` - List categories
- `POST /api/v1/categories` - Create category (auth required)
- `DELETE /api/v1/categories/{id}` - Delete category (auth required)

### Tags
- `GET /api/v1/tags` - List tags
- `POST /api/v1/tags` - Create tags (auth required)
- `DELETE /api/v1/tags/{id}` - Delete tag (auth required)

## Authentication

Include JWT in request header:
```
Authorization: Bearer <your-jwt-token>
Testing
bash./mvnw test
Prerequisites

JDK 21+
Docker
Maven (bundled)
