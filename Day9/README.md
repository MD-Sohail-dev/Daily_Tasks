# TaskManagement Application

A simple **Task Management System** built using **Spring Boot** that allows users to create, view, search, and delete tasks. The project demonstrates RESTful API development with **Spring Web**, database integration with **Spring Data JPA**, and clean entity modeling using **Lombok**.

---

## Features

- Create new tasks with title and description
- Fetch all tasks
- Fetch a task by its ID
- Delete tasks by ID
- Search tasks by title or keyword in description
- RESTful API endpoints for easy integration

---

## Technologies Used

- **Java 1.8**
- **Spring Boot 2.7.18**
- **Spring Web** – for building RESTful APIs
- **Spring Data JPA** – for database operations
- **Hibernate** – ORM framework for mapping entities
- **MySQL** – relational database
- **Lombok** – to reduce boilerplate code
- **HikariCP** – connection pooling
- **Maven** – project management and dependency handling
- **Logback / SLF4J** – logging
- **IntelliJ IDEA**

---

## Project Structure

MDSohail.TaskManagement/
│
├── src/main/java/
│ ├── MDSohail.TaskManagement/
│ │ └── TaskManagementApplication.java # Spring Boot main class
│ ├── MDSohail.TaskManagement.controller/
│ │ └── TaskController.java # REST API endpoints
│ ├── MDSohail.TaskManagement.entity/
│ │ └── Task.java # Task entity with Lombok annotations
│ ├── MDSohail.TaskManagement.repository/
│ │ └── TaskRepository.java # JPA repository for Task
│ └── MDSohail.TaskManagement.service/
│ └── TaskService.java # Service layer for business logic
│
├── src/main/resources/
│ └── application.properties # Spring Boot configuration
│
├── pom.xml # Maven dependencies
└── README.md



---

## API Endpoints

| HTTP Method | Endpoint                       | Description                           |
|------------|--------------------------------|---------------------------------------|
| POST       | `/api/tasks`                    | Create a new task                      |
| GET        | `/api/tasks`                    | Get all tasks                          |
| GET        | `/api/tasks/{id}`               | Get task by ID                         |
| DELETE     | `/api/tasks/{id}`               | Delete task by ID                      |
| GET        | `/api/tasks/search/title/{title}`  | Search tasks by title                  |
| GET        | `/api/tasks/search/keyword/{keyword}` | Search tasks by keyword in description |

---

## Database Configuration

The project uses **MySQL** as the database. Configure your database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
---

Dependencies (Maven)

Spring Boot Starter Web

Spring Boot Starter Data JPA

MySQL Connector Java

Lombok

Spring Boot Starter Test (for testing)

Logging

The application uses SLF4J with Lombok’s @Slf4j annotation for logging important events and errors in the application.

---


Notes

The project uses Lombok annotations (@Data, @NoArgsConstructor, @AllArgsConstructor) to reduce boilerplate code for getters, setters, constructors, etc.

The Task entity contains id, title, and description. Make sure id is auto-generated in MySQL.

Spring Data JPA provides CRUD operations and custom query methods.

The project uses RESTful principles for API endpoints.

Ensure MySQL server is running before starting the application.

---


Author

MD Sohail Ansari

---

## Screenshots

### Screenshot 1: 
![Screenshot1](Screenshot1.png)

### Screenshot 2: Create Task
![Screenshot2](Screenshot2.png)

### Screenshot 3: Search / Task Details
![Screenshot3](Screenshot3.png)

