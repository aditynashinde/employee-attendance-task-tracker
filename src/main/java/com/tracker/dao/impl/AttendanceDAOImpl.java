package com.tracker.dao.impl;

import com.tracker.dao.AttendanceDAO;
import com.tracker.model.Attendance;
import com.tracker.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public void checkIn(int empId) {
        String sql = "INSERT INTO Attendance (emp_id, check_in_time, date) VALUES (?, NOW(), CURDATE())";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkOut(int empId) {
        String sql = "UPDATE Attendance SET check_out_time = NOW() WHERE emp_id = ? AND date = CURDATE() AND check_out_time IS NULL";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Attendance> getAttendanceByDate(Date date) {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM Attendance WHERE date = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance att = new Attendance();
                att.setAttendanceId(rs.getInt("attendance_id"));
                att.setEmpId(rs.getInt("emp_id"));
                att.setCheckInTime(rs.getTimestamp("check_in_time"));
                att.setCheckOutTime(rs.getTimestamp("check_out_time"));
                att.setDate(rs.getDate("date"));
                list.add(att);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(int empId) {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM Attendance WHERE emp_id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance att = new Attendance();
                att.setAttendanceId(rs.getInt("attendance_id"));
                att.setEmpId(rs.getInt("emp_id"));
                att.setCheckInTime(rs.getTimestamp("check_in_time"));
                att.setCheckOutTime(rs.getTimestamp("check_out_time"));
                att.setDate(rs.getDate("date"));
                list.add(att);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
