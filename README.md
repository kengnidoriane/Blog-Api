# Blog API

This is a RESTful API for a blog application built with Spring Boot. The API allows you to create, read, update, and delete articles, as well as add comments to articles.

## Features

- Create articles with title, content, and publication date
- Read all articles or a specific article by ID
- Update existing articles
- Delete articles
- Add comments to articles

## Prerequisites

- Java 21
- Maven
- PostgreSQL

## Installation

1. Clone the repository

```bash
git clone <github.com/kengnidoriane/Blog-Api>
cd Api-Blog
```

2. Configure the database

Create a PostgreSQL database named `blogDB` and update the `application.properties` file with your database credentials if needed:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blogDB
spring.datasource.username=postgres
spring.datasource.password=your_password
```

3. Build and run the application

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Documentation

Once the application is running, you can access the Swagger UI documentation at:

```
http://localhost:8080/swagger-ui.html
```

## API Endpoints

### Articles

- **GET /api/articles** - Get all articles
- **GET /api/articles/{id}** - Get an article by ID
- **POST /api/articles** - Create a new article
- **PUT /api/articles/{id}** - Update an article
- **DELETE /api/articles/{id}** - Delete an article

### Comments

- **POST /api/articles/{articleId}/comments** - Add a comment to an article

## Testing the API

You can test the API using tools like Postman, cURL, or any HTTP client.

### Example Requests

#### Create an Article

```bash
curl -X POST http://localhost:8080/api/articles \
  -H "Content-Type: application/json" \
  -d '{"title":"My First Article","content":"This is the content of my first article."}'
```

#### Get All Articles

```bash
curl -X GET http://localhost:8080/api/articles
```

#### Get Article by ID

```bash
curl -X GET http://localhost:8080/api/articles/1
```

#### Update an Article

```bash
curl -X PUT http://localhost:8080/api/articles/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated Title","content":"Updated content."}'
```

#### Delete an Article

```bash
curl -X DELETE http://localhost:8080/api/articles/1
```

#### Add a Comment to an Article

```bash
curl -X POST http://localhost:8080/api/articles/1/comments \
  -H "Content-Type: application/json" \
  -d '{"content":"This is a comment on the article."}'
```

## Error Handling

The API includes comprehensive error handling:

- 404 Not Found - When a requested resource doesn't exist
- 400 Bad Request - When validation fails
- 500 Internal Server Error - For unexpected server errors

## Technologies Used

- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- SpringDoc OpenAPI (Swagger)
- Hibernate Validator