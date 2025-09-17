package com.tracker.util;

import com.tracker.model.Attendance;
import com.tracker.model.Task;
import java.util.List;

public class CSVUtil {
    public static void exportAttendanceReport(List<Attendance> attendanceList, String filePath) {
        try (com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(new java.io.FileWriter(filePath))) {
            String[] header = {"Attendance ID", "Employee ID", "Check-In Time", "Check-Out Time", "Date"};
            writer.writeNext(header);
            for (Attendance att : attendanceList) {
                String[] row = {
                    String.valueOf(att.getAttendanceId()),
                    String.valueOf(att.getEmpId()),
                    att.getCheckInTime() != null ? att.getCheckInTime().toString() : "",
                    att.getCheckOutTime() != null ? att.getCheckOutTime().toString() : "",
                    att.getDate() != null ? att.getDate().toString() : ""
                };
                writer.writeNext(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportTaskReport(List<Task> taskList, String filePath) {
        try (com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(new java.io.FileWriter(filePath))) {
            String[] header = {"Task ID", "Employee ID", "Task Description", "Start Time", "End Time", "Date"};
            writer.writeNext(header);
            for (Task task : taskList) {
                String[] row = {
                    String.valueOf(task.getTaskId()),
                    String.valueOf(task.getEmpId()),
                    task.getTaskDescription(),
                    task.getStartTime() != null ? task.getStartTime().toString() : "",
                    task.getEndTime() != null ? task.getEndTime().toString() : "",
                    task.getDate() != null ? task.getDate().toString() : ""
                };
                writer.writeNext(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
