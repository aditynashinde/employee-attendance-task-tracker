# Employee Attendance & Task Tracker

A Java console application to manage employee attendance, daily tasks, and generate CSV reports. Built with JDBC and Maven.

## Features
- Employee CRUD (add, update, delete, list)
- Attendance check-in/check-out
- Task logging and history
- CSV report export (attendance, tasks)

## Tech Stack
- Java 17
- Maven
- MySQL (JDBC)
- OpenCSV

## Getting Started
1. Clone the repo and open in VS Code/IDE.
2. Set up MySQL and run `src/main/resources/schema.sql` to create tables.
3. Update DB credentials in `DBUtil.java`.
4. Build with `mvn clean install`.
5. Run `MainApp.java`.

## Project Structure
- `model/` - Entity classes
- `dao/` - DAO interfaces
- `dao/impl/` - JDBC implementations
- `util/` - Utilities (DB, CSV)
- `app/` - Main application

## Extension Ideas
- Web version (Servlet/Spring Boot)
- Authentication
- Email reports

---
MIT License
