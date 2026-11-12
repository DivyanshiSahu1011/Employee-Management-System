# Employee Management System

A console-based Employee Management System developed using Core Java. This application allows users to manage employee records through a menu-driven interface and stores employee information in a local text file.

## Features

- **Add Employee:** Add a new employee with ID, name, department and salary.
- **View Employees:** Display all stored employee records.
- **Search Employee:** Find an employee using their unique ID.
- **Update Employee:** Modify an existing employee's name, department and salary.
- **Delete Employee:** Remove an employee record using their ID.
- **File Persistence:** Automatically save employee records to `employees.txt` and load existing records when the application starts.
- **Duplicate ID Prevention:** Prevent adding employees with an existing ID.
- **Input Validation:** Validate employee IDs, salary values and text inputs.

## Technologies Used

- Java (Core Java)
- Java Collections Framework (`ArrayList`)
- Java File Handling (`BufferedReader`, `BufferedWriter`, `Files`)
- Exception Handling
- VS Code / Any Java IDE

## Project Structure

```text
Employee-Management-System/
│
├── Main.java
├── Employee.java
├── EmployeeManager.java
├── employees.txt
├── README.md
└── .gitignore
```

## Java Concepts Implemented

- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- ArrayList
- CRUD Operations
- Methods and Loops
- Conditional Statements and Switch
- Exception Handling (try-catch)
- File Handling and Data Persistence
- Input Validation

## How to Run the Project

**Prerequisite:** JDK 8 or later installed on your system.

1. Clone or download this repository.
2. Open the project folder in VS Code or any Java IDE.
3. Open the terminal in the project directory.
4. Compile the Java files:

```bash
javac Employee.java EmployeeManager.java Main.java
```

5. Run the application:

```bash
java Main
```

## Application Menu

```text
==================================
     EMPLOYEE MANAGEMENT SYSTEM
==================================

----------- MENU -----------
1. Add employee
2. View all employees
3. Search employee by ID
4. Update employee
5. Delete employee
6. Exit
----------------------------
```

## Data Storage

Employee records are stored in a local text file named `employees.txt`.

Each employee record follows this format:

```text
ID|Name|Department|Salary
```

Example:

```text
101|DIVYANSHI|IT|50000.0
```

The application loads existing records when it starts and saves changes whenever an employee is added, updated or deleted.

## Important Note

This is a beginner-level, console-based Java project demonstrating object-oriented programming, CRUD operations and file handling.

It uses local text-file storage instead of a database and does not include a graphical user interface or web application.

## Author

**Divyanshi Sahu**

GitHub: https://github.com/DivyanshiSahu1011
