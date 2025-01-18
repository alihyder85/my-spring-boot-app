# My Spring Boot Application

This is a simple Spring Boot application that connects to a local H2 database and exposes a GET endpoint to retrieve data.

## Project Structure

```
my-spring-boot-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── myapp
│   │   │               ├── MySpringBootApplication.java
│   │   │               ├── controller
│   │   │               │   └── DataController.java
│   │   │               ├── model
│   │   │               │   └── DataModel.java
│   │   │               └── repository
│   │   │                   └── DataRepository.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── myapp
│                       └── MySpringBootApplicationTests.java
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd my-spring-boot-app
   ```

2. **Run the application:**
   ```
   ./mvnw spring-boot:run
   ```

3. **Access the GET endpoint:**
   Open your browser and navigate to `http://localhost:8080/data` to retrieve data from the H2 database.

## Usage

This application initializes the H2 database with sample data defined in `data.sql`. You can modify the SQL statements in that file to change the initial data.

## Dependencies

This project uses the following dependencies:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database
- Lombok (optional)

## Testing

To run the tests, use the following command:
```
./mvnw test
```

This will execute the test cases defined in `MySpringBootApplicationTests.java`.