package com.tracker.dao;

import com.tracker.model.Attendance;
import java.sql.Date;
import java.util.List;

public interface AttendanceDAO {
    void checkIn(int empId);
    void checkOut(int empId);
    List<Attendance> getAttendanceByDate(Date date);
    List<Attendance> getAttendanceByEmployee(int empId);
}
