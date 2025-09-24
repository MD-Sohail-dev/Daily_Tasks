# JDBC CRUD Maven Project

## Overview
This is a simple **Java Maven project** demonstrating **CRUD (Create, Read, Update, Delete)** operations on a **MySQL database** using **JDBC**.  
The project is menu-driven, allowing the user to perform operations interactively via the console.

---

## Features
- Connects to a MySQL database using JDBC.
- Menu-driven options to:
  - Insert a new user.
  - View all users.
  - Update an existing user.
  - Delete a user.
  - Exit the application.
- Uses **PreparedStatement** to prevent SQL injection.
- Closes all database resources properly to avoid memory leaks.
- Fully Maven-based for easy dependency management.

---

## Project Structure
jdbc-crud-maven/
├── pom.xml # Maven configuration file
├── src/
│ └── main/
│ └── java/
│ └── org/
│ └── example/
│ └── Main.java # Main Java program with CRUD operations
└── .gitignore # Files/folders ignored by Git


---

## Dependencies
This project uses **Maven** to manage dependencies.  
The main dependency is the **MySQL JDBC Driver**:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>


This dependency allows the Java program to connect to a MySQL database.
Maven automatically downloads and manages this library.

```

---

Database Setup

Install MySQL or use an existing MySQL server.
Create a new database and table using the following SQL commands:


CREATE DATABASE testdb;

USE testdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

id: Auto-increment primary key.
name: User’s name.
email: User’s email (unique).

---
How It Works

Database Connection
The program connects to the MySQL database using JDBC with the URL, username, and password defined in Main.java.

Menu-Driven Interface

The program displays a menu with options to Insert, View, Update, Delete, or Exit.

User input is read using Scanner.

CRUD Operations

Create (Insert): Adds a new user to the users table using a PreparedStatement.

Read (Select): Retrieves all users from the users table using a Statement and displays them in the console.

Update: Updates an existing user’s name and email based on their ID using a PreparedStatement.

Delete: Deletes a user from the table using their ID with a PreparedStatement.

Security

Uses PreparedStatement for all SQL operations to prevent SQL injection attacks.

Resource Management

Uses try-with-resources and finally blocks to ensure that database connections, statements, and result sets are closed properly.

---

Key Classes & Methods

Main.java
The main class contains:

main(String[] args): Displays menu and handles user input.

insertUser(Connection conn, String name, String email): Inserts a user.

readUsers(Connection conn): Displays all users.

updateUser(Connection conn, int id, String newName, String newEmail): Updates a user.

deleteUser(Connection conn, int id): Deletes a user.

---


Benefits of This Project

Provides hands-on experience with JDBC and MySQL.

Demonstrates proper CRUD operations.

Shows how to manage database resources efficiently.

A good starting point for Java database applications or full-stack projects.

---


## Screenshots

### Screenshot 1: Menu
![Screenshot 1](Screenshot1.png)

### Screenshot 2: Users Display
![Screenshot 2](Screenshot2.png)


