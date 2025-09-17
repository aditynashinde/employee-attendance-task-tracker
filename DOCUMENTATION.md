# 📚 Project Documentation: Employee Attendance & Task Tracker

This document provides a detailed overview of the project structure, the purpose of each file/folder, and guidance for contributors and maintainers.

---

## 📁 Folder & File Structure

```
employee-attendance-task-tracker/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/tracker/
│       │       ├── app/
│       │       │   └── MainApp.java
│       │       ├── dao/
│       │       │   ├── EmployeeDAO.java
│       │       │   ├── AttendanceDAO.java
│       │       │   └── TaskDAO.java
│       │       ├── dao/impl/
│       │       │   ├── EmployeeDAOImpl.java
│       │       │   ├── AttendanceDAOImpl.java
│       │       │   └── TaskDAOImpl.java
│       │       ├── model/
│       │       │   ├── Employee.java
│       │       │   ├── Attendance.java
│       │       │   └── Task.java
│       │       └── util/
│       │           ├── DBUtil.java
│       │           └── CSVUtil.java
│       └── resources/
│           └── schema.sql
├── pom.xml
├── .gitignore
├── README.md
├── DOCUMENTATION.md
└── .github/
```

---

## 📝 File/Folder Descriptions

### Main Application
- **app/MainApp.java**: Entry point. Console menu system for all modules.

### Data Access Layer
- **dao/EmployeeDAO.java**: Interface for employee CRUD operations.
- **dao/AttendanceDAO.java**: Interface for attendance operations.
- **dao/TaskDAO.java**: Interface for task operations.
- **dao/impl/**: JDBC implementations of the above interfaces.

### Models
- **model/Employee.java**: Employee entity (fields: empId, name, department, email, designation, status).
- **model/Attendance.java**: Attendance entity (fields: attendanceId, empId, checkInTime, checkOutTime, date).
- **model/Task.java**: Task entity (fields: taskId, empId, taskDescription, startTime, endTime, date).

### Utilities
- **util/DBUtil.java**: Handles JDBC connection to MySQL.
- **util/CSVUtil.java**: Exports attendance/task data to CSV using OpenCSV.

### Resources
- **resources/schema.sql**: SQL script to create all required tables.

### Project Config
- **pom.xml**: Maven configuration (dependencies, plugins, build info).
- **.gitignore**: Files/folders to ignore in git.
- **README.md**: Project overview, setup, and usage.
- **DOCUMENTATION.md**: (This file) In-depth documentation and file purpose.
- **.github/**: GitHub-specific configs (e.g., Copilot instructions).

---

## 🛠️ How to Extend or Maintain
- Add new features by creating new DAO/model/utility classes as needed.
- For web version, add a new module (e.g., `web/` or `springboot/`).
- Keep `README.md` and `DOCUMENTATION.md` up to date with all changes.

---

## 🤝 Contributors Guide
- Follow Java naming conventions and best practices.
- Document new classes/methods with Javadoc.
- Test all new features before pushing.
- Open issues or pull requests for major changes.

---

## 📄 License
MIT
