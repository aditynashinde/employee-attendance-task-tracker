package com.tracker.dao;

import com.tracker.model.Task;
import java.sql.Date;
import java.util.List;

public interface TaskDAO {
    void logTask(Task task);
    void updateTask(Task task);
    void deleteTask(int taskId);
    List<Task> getTasksByEmployee(int empId, Date date);
}
