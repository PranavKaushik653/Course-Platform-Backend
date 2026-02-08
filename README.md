# Course Platform Backend API

Backend service for a learning platform built with Spring Boot 4.0.2 and Java 21.

## 🚀 Live Deployment
https://course-platform-backend-production.up.railway.app


## 🚀 Features

- 📚 Browse and search courses, topics, and subtopics
- 🔐 JWT-based authentication
- 📝 Course enrollment system
- 📊 Progress tracking for subtopics
- 🔍 Full-text search functionality
- 📖 Swagger/OpenAPI documentation

## 🛠️ Tech Stack

- **Java:** 21
- **Spring Boot:** 4.0.2
- **Database:** PostgreSQL
- **Security:** Spring Security with JWT
- **ORM:** JPA/Hibernate
- **Documentation:** Swagger/OpenAPI
- **Build Tool:** Maven

## 📋 Prerequisites

- Java 21
- PostgreSQL 18
- Maven 3.8+

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/PranavKaushik653/Course-Platform-Backend.git
cd Course-Platform-Backend
```

### 2. Database Setup

Create PostgreSQL database:
```sql
CREATE DATABASE course_platform;
```

### 3. Application Configuration

Copy the example configuration file:
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Update `application.properties` with your credentials:
- `spring.datasource.password` - Your PostgreSQL password
- `jwt.secret` - A secure random string (at least 256 bits)

### 4. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 5. Access Swagger UI

Open your browser and navigate to:
```
http://localhost:8080/swagger-ui.html
```

## 📚 API Documentation

### Public Endpoints (No Authentication)

- `GET /api/courses` - List all courses
- `GET /api/courses/{id}` - Get course details
- `GET /api/search?q={query}` - Search courses and content

### Authentication Endpoints

- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login and receive JWT token

### Protected Endpoints (JWT Required)

- `POST /api/courses/{courseId}/enroll` - Enroll in a course
- `POST /api/subtopics/{subtopicId}/complete` - Mark subtopic as completed
- `GET /api/enrollments/{enrollmentId}/progress` - View progress

## 🗄️ Database Schema

- **User** - User accounts
- **Course** - Course information
- **Topic** - Course topics
- **Subtopic** - Topic subtopics with markdown content
- **Enrollment** - User-Course enrollment records
- **SubtopicProgress** - Tracks completed subtopics

## 🌱 Seed Data

The application automatically loads seed data from `seed_data/courses.json` on first startup.

## 🚀 Deployment

Deployment URL: [Will be updated after deployment]

## 📝 Assignment Details

This project is an assignment submission for Backend Intern position.

**Assignment Requirements:**
- ✅ Course browsing and search
- ✅ JWT authentication
- ✅ Progress tracking
- ✅ Swagger documentation
- ✅ Public deployment

## 👤 Author

**Pranav Kaushik**
- GitHub: [@PranavKaushik653](https://github.com/PranavKaushik653)

## 📄 License

This project is for assignment purposes.
