-- Employee Table
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    designation VARCHAR(100),
    status VARCHAR(20) DEFAULT 'active'
);

-- Attendance Table
CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    check_in_time TIMESTAMP,
    check_out_time TIMESTAMP,
    date DATE,
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);

-- Task Table
CREATE TABLE Task (
    task_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    task_description VARCHAR(255),
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    date DATE,
    FOREIGN KEY (emp_id) REFERENCES Employee(emp_id)
);