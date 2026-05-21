# Azure Demo Comments API

Simple Spring Boot REST API using Java 21, Gradle, Spring Data JPA, DTO validation, and SQLite.

## Run Locally

Make sure Java 21 is installed, then run:

```powershell
.\gradlew.bat bootRun
```

The API starts on `http://localhost:8080`.

SQLite stores data in `comments.db` in the project root. The `comments` table is created automatically by Hibernate.

On macOS or Linux, use:

```bash
./gradlew bootRun
```

## Endpoints

Create a comment:

```powershell
curl -Method POST http://localhost:8080/comments `
  -ContentType "application/json" `
  -Body '{"author":"Aleks","content":"Hello from SQLite"}'
```

List comments:

```powershell
curl http://localhost:8080/comments
```

## Project Structure

```text
src/main/java/com/example/azuredemo
├── controller
├── dto
├── entity
├── repository
└── service
```
