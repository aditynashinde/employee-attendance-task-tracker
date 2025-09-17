package com.tracker.app;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
    com.tracker.dao.EmployeeDAO employeeDAO = new com.tracker.dao.impl.EmployeeDAOImpl();
    com.tracker.dao.AttendanceDAO attendanceDAO = new com.tracker.dao.impl.AttendanceDAOImpl();
    com.tracker.dao.TaskDAO taskDAO = new com.tracker.dao.impl.TaskDAOImpl();
        while (running) {
            System.out.println("\n==== Employee Attendance & Task Tracker ====");
            System.out.println("1. Manage Employees");
            System.out.println("2. Attendance");
            System.out.println("3. Task Management");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    boolean empMenu = true;
                    while (empMenu) {
                        System.out.println("\n-- Employee Management --");
                        System.out.println("1. Add Employee");
                        System.out.println("2. Update Employee");
                        System.out.println("3. Delete Employee");
                        System.out.println("4. List Employees");
                        System.out.println("5. Back");
                        System.out.print("Select an option: ");
                        int empChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (empChoice) {
                            case 1:
                                com.tracker.model.Employee newEmp = new com.tracker.model.Employee();
                                System.out.print("Name: "); newEmp.setName(scanner.nextLine());
                                System.out.print("Department: "); newEmp.setDepartment(scanner.nextLine());
                                System.out.print("Email: "); newEmp.setEmail(scanner.nextLine());
                                System.out.print("Designation: "); newEmp.setDesignation(scanner.nextLine());
                                System.out.print("Status (active/inactive): "); newEmp.setStatus(scanner.nextLine());
                                employeeDAO.addEmployee(newEmp);
                                System.out.println("Employee added.");
                                break;
                            case 2:
                                System.out.print("Enter Employee ID to update: ");
                                int upId = scanner.nextInt(); scanner.nextLine();
                                com.tracker.model.Employee upEmp = employeeDAO.getEmployeeById(upId);
                                if (upEmp == null) {
                                    System.out.println("Employee not found.");
                                    break;
                                }
                                System.out.print("Name [" + upEmp.getName() + "]: "); String n = scanner.nextLine();
                                if (!n.isEmpty()) upEmp.setName(n);
                                System.out.print("Department [" + upEmp.getDepartment() + "]: "); String d = scanner.nextLine();
                                if (!d.isEmpty()) upEmp.setDepartment(d);
                                System.out.print("Email [" + upEmp.getEmail() + "]: "); String e = scanner.nextLine();
                                if (!e.isEmpty()) upEmp.setEmail(e);
                                System.out.print("Designation [" + upEmp.getDesignation() + "]: "); String des = scanner.nextLine();
                                if (!des.isEmpty()) upEmp.setDesignation(des);
                                System.out.print("Status [" + upEmp.getStatus() + "]: "); String s = scanner.nextLine();
                                if (!s.isEmpty()) upEmp.setStatus(s);
                                employeeDAO.updateEmployee(upEmp);
                                System.out.println("Employee updated.");
                                break;
                            case 3:
                                System.out.print("Enter Employee ID to delete: ");
                                int delId = scanner.nextInt(); scanner.nextLine();
                                employeeDAO.deleteEmployee(delId);
                                System.out.println("Employee deleted.");
                                break;
                            case 4:
                                java.util.List<com.tracker.model.Employee> emps = employeeDAO.getAllEmployees();
                                System.out.println("\nID | Name | Department | Email | Designation | Status");
                                for (com.tracker.model.Employee emp : emps) {
                                    System.out.println(emp.getEmpId() + " | " + emp.getName() + " | " + emp.getDepartment() + " | " + emp.getEmail() + " | " + emp.getDesignation() + " | " + emp.getStatus());
                                }
                                break;
                            case 5:
                                empMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;
                case 2:
                    boolean attMenu = true;
                    while (attMenu) {
                        System.out.println("\n-- Attendance --");
                        System.out.println("1. Check-In");
                        System.out.println("2. Check-Out");
                        System.out.println("3. View Attendance by Date");
                        System.out.println("4. View Attendance by Employee");
                        System.out.println("5. Back");
                        System.out.print("Select an option: ");
                        int attChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (attChoice) {
                            case 1:
                                System.out.print("Enter Employee ID: ");
                                int inId = scanner.nextInt(); scanner.nextLine();
                                attendanceDAO.checkIn(inId);
                                System.out.println("Checked in.");
                                break;
                            case 2:
                                System.out.print("Enter Employee ID: ");
                                int outId = scanner.nextInt(); scanner.nextLine();
                                attendanceDAO.checkOut(outId);
                                System.out.println("Checked out.");
                                break;
                            case 3:
                                System.out.print("Enter date (yyyy-mm-dd): ");
                                String dateStr = scanner.nextLine();
                                java.sql.Date date = java.sql.Date.valueOf(dateStr);
                                java.util.List<com.tracker.model.Attendance> attList = attendanceDAO.getAttendanceByDate(date);
                                System.out.println("\nID | EmpID | Check-In | Check-Out | Date");
                                for (com.tracker.model.Attendance att : attList) {
                                    System.out.println(att.getAttendanceId() + " | " + att.getEmpId() + " | " + att.getCheckInTime() + " | " + att.getCheckOutTime() + " | " + att.getDate());
                                }
                                break;
                            case 4:
                                System.out.print("Enter Employee ID: ");
                                int empId = scanner.nextInt(); scanner.nextLine();
                                java.util.List<com.tracker.model.Attendance> empAttList = attendanceDAO.getAttendanceByEmployee(empId);
                                System.out.println("\nID | EmpID | Check-In | Check-Out | Date");
                                for (com.tracker.model.Attendance att : empAttList) {
                                    System.out.println(att.getAttendanceId() + " | " + att.getEmpId() + " | " + att.getCheckInTime() + " | " + att.getCheckOutTime() + " | " + att.getDate());
                                }
                                break;
                            case 5:
                                attMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;
                case 3:
                    boolean taskMenu = true;
                    while (taskMenu) {
                        System.out.println("\n-- Task Management --");
                        System.out.println("1. Log Task");
                        System.out.println("2. Update Task");
                        System.out.println("3. Delete Task");
                        System.out.println("4. View Tasks by Employee & Date");
                        System.out.println("5. Back");
                        System.out.print("Select an option: ");
                        int tChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (tChoice) {
                            case 1:
                                com.tracker.model.Task newTask = new com.tracker.model.Task();
                                System.out.print("Employee ID: "); newTask.setEmpId(scanner.nextInt()); scanner.nextLine();
                                System.out.print("Task Description: "); newTask.setTaskDescription(scanner.nextLine());
                                System.out.print("Start Time (yyyy-mm-dd hh:mm:ss): "); newTask.setStartTime(java.sql.Timestamp.valueOf(scanner.nextLine()));
                                System.out.print("End Time (yyyy-mm-dd hh:mm:ss): "); newTask.setEndTime(java.sql.Timestamp.valueOf(scanner.nextLine()));
                                System.out.print("Date (yyyy-mm-dd): "); newTask.setDate(java.sql.Date.valueOf(scanner.nextLine()));
                                taskDAO.logTask(newTask);
                                System.out.println("Task logged.");
                                break;
                            case 2:
                                System.out.print("Task ID to update: ");
                                int utId = scanner.nextInt(); scanner.nextLine();
                                com.tracker.model.Task utTask = null;
                                java.util.List<com.tracker.model.Task> utList = taskDAO.getTasksByEmployee(-1, null); // get all tasks
                                for (com.tracker.model.Task t : utList) if (t.getTaskId() == utId) utTask = t;
                                if (utTask == null) {
                                    System.out.println("Task not found.");
                                    break;
                                }
                                System.out.print("Task Description [" + utTask.getTaskDescription() + "]: "); String td = scanner.nextLine();
                                if (!td.isEmpty()) utTask.setTaskDescription(td);
                                System.out.print("Start Time [" + utTask.getStartTime() + "]: "); String st = scanner.nextLine();
                                if (!st.isEmpty()) utTask.setStartTime(java.sql.Timestamp.valueOf(st));
                                System.out.print("End Time [" + utTask.getEndTime() + "]: "); String et = scanner.nextLine();
                                if (!et.isEmpty()) utTask.setEndTime(java.sql.Timestamp.valueOf(et));
                                System.out.print("Date [" + utTask.getDate() + "]: "); String dt = scanner.nextLine();
                                if (!dt.isEmpty()) utTask.setDate(java.sql.Date.valueOf(dt));
                                taskDAO.updateTask(utTask);
                                System.out.println("Task updated.");
                                break;
                            case 3:
                                System.out.print("Task ID to delete: ");
                                int delTid = scanner.nextInt(); scanner.nextLine();
                                taskDAO.deleteTask(delTid);
                                System.out.println("Task deleted.");
                                break;
                            case 4:
                                System.out.print("Employee ID: "); int empId = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Date (yyyy-mm-dd): "); String tdate = scanner.nextLine();
                                java.util.List<com.tracker.model.Task> tList = taskDAO.getTasksByEmployee(empId, java.sql.Date.valueOf(tdate));
                                System.out.println("\nID | EmpID | Description | Start | End | Date");
                                for (com.tracker.model.Task t : tList) {
                                    System.out.println(t.getTaskId() + " | " + t.getEmpId() + " | " + t.getTaskDescription() + " | " + t.getStartTime() + " | " + t.getEndTime() + " | " + t.getDate());
                                }
                                break;
                            case 5:
                                taskMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;
                case 4:
                    boolean repMenu = true;
                    while (repMenu) {
                        System.out.println("\n-- Reports --");
                        System.out.println("1. Export Attendance by Date");
                        System.out.println("2. Export Tasks by Date");
                        System.out.println("3. Back");
                        System.out.print("Select an option: ");
                        int rChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (rChoice) {
                            case 1:
                                System.out.print("Enter date (yyyy-mm-dd): "); String adate = scanner.nextLine();
                                java.sql.Date attDate = java.sql.Date.valueOf(adate);
                                java.util.List<com.tracker.model.Attendance> attList = attendanceDAO.getAttendanceByDate(attDate);
                                System.out.print("Enter file path to export CSV: "); String afile = scanner.nextLine();
                                com.tracker.util.CSVUtil.exportAttendanceReport(attList, afile);
                                System.out.println("Attendance report exported.");
                                break;
                            case 2:
                                System.out.print("Enter date (yyyy-mm-dd): "); String tdate = scanner.nextLine();
                                System.out.print("Employee ID: "); int empId = scanner.nextInt(); scanner.nextLine();
                                java.util.List<com.tracker.model.Task> tList = taskDAO.getTasksByEmployee(empId, java.sql.Date.valueOf(tdate));
                                System.out.print("Enter file path to export CSV: "); String tfile = scanner.nextLine();
                                com.tracker.util.CSVUtil.exportTaskReport(tList, tfile);
                                System.out.println("Task report exported.");
                                break;
                            case 3:
                                repMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Try again.");
                        }
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
