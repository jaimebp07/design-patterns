# 📁 Design Patterns Adapter Project

This project demonstrates the **Adapter Design Pattern** in a Java Spring Boot application. It focuses on reading files in different formats (e.g., CSV, Excel) using interchangeable adapter implementations. The application parses input data into a common format — in this case, a list of `Person` objects — regardless of the file type.

## 🎯 Purpose

The goal is to practice **clean code**, **SOLID principles**, and **good architectural design** by using:

- Interface-based programming
- The Adapter Pattern
- Spring Boot's dependency injection
- Unit testing with JUnit and Mockito
- Code coverage analysis with JaCoCo

---

## ✅ Prerequisites

Make sure you have the following installed:

- Java 17 (or your project's Java version)
- Maven 3.6+
- Git (optional)

---

## Aften adding dependencias

```bash
mvn clean compile
```


## 🚀 How to Run Tests

To run all unit tests in the project, use:

```bash
mvn clean test
```

## 📊 Generate Code Coverage Report
```bash
mvn clean verify
```

