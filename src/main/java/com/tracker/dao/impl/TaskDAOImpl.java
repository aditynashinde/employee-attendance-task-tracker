package com.tracker.dao.impl;

import com.tracker.dao.TaskDAO;
import com.tracker.model.Task;
import com.tracker.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    @Override
    public void logTask(Task task) {
        String sql = "INSERT INTO Task (emp_id, task_description, start_time, end_time, date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, task.getEmpId());
            ps.setString(2, task.getTaskDescription());
            ps.setTimestamp(3, task.getStartTime());
            ps.setTimestamp(4, task.getEndTime());
            ps.setDate(5, task.getDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTask(Task task) {
        String sql = "UPDATE Task SET task_description=?, start_time=?, end_time=?, date=? WHERE task_id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, task.getTaskDescription());
            ps.setTimestamp(2, task.getStartTime());
            ps.setTimestamp(3, task.getEndTime());
            ps.setDate(4, task.getDate());
            ps.setInt(5, task.getTaskId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(int taskId) {
        String sql = "DELETE FROM Task WHERE task_id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, taskId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getTasksByEmployee(int empId, Date date) {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM Task WHERE emp_id=? AND date=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, empId);
            ps.setDate(2, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setTaskId(rs.getInt("task_id"));
                task.setEmpId(rs.getInt("emp_id"));
                task.setTaskDescription(rs.getString("task_description"));
                task.setStartTime(rs.getTimestamp("start_time"));
                task.setEndTime(rs.getTimestamp("end_time"));
                task.setDate(rs.getDate("date"));
                list.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
