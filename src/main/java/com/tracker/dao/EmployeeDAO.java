package com.tracker.dao;

import com.tracker.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee emp);
    void updateEmployee(Employee emp);
    void deleteEmployee(int empId);
    Employee getEmployeeById(int empId);
    List<Employee> getAllEmployees();
}
