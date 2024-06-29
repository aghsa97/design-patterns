package com.mycompany.app.easy.task_manager;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mycompany.app.easy.task_manager.task.Status;
import com.mycompany.app.easy.task_manager.task.Task;

public class TaskManger {
    // 1. The task management system should allow users to create, update, and delete tasks.
    // 3. Users should be able to assign tasks to other users and set reminders for tasks.
    // 4. The system should support searching and filtering tasks based on various criteria 
    // (e.g., priority, due date, assigned user).
    // 5. Users should be able to mark tasks as completed and view their task history.

    private List<Task> tasks;
    private static TaskManger INSTANCE;

    private TaskManger() {
        this.tasks = new ArrayList<Task>();
    }

    public static synchronized TaskManger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskManger();
        }
        return INSTANCE;
    }

    public void createTask(Task task) {
        this.tasks.add(task);
    }

    public void updateTask(Task updatedTask) {
        Task existingTask = tasks.get(updatedTask.getId());
        if (existingTask != null) {
            synchronized (existingTask) {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setDueDate(updatedTask.getDueDate());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setStatus(updatedTask.getStatus());
            }
        }
    }

    public void deleteTask(int taskId) {
        if (tasks.get(taskId) != null) {
            tasks.remove(taskId);
        }
    }

    public synchronized void assignUserToTask(User assignedUser, Task task) {
        if (tasks.get(task.getId()) != null) {
            task.setAssignedTo(assignedUser);
        }
    }

    public void setReminder(Date reminder, Task task) {
        if (tasks.get(task.getId()) != null) {
            synchronized (task) {
                task.setReminder(reminder);
            }
        }
    }

    public void markTaskAsCompleted(int taskId) {
        Task completeTask = tasks.get(taskId);
        if (completeTask != null) {
            synchronized (completeTask) {
                completeTask.setStatus(Status.COMPLETED);
            }
        }
    }

    public List<Task> viewHistory(User user) {
        List<Task> historyTasks = new ArrayList<Task>();
        LocalDate today = LocalDate.now();
        for (Task task : tasks) {
            LocalDate due_date = task.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (due_date.compareTo(today) <= 0 && task.getAssignedUser() != null && task.getAssignedUser().equals(user)) {
                historyTasks.add(task);
            }
        }

        return historyTasks;
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> results = new ArrayList<Task>();

        for (Task task : tasks) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                results.add(task);
            }
        }

        return results;
    }

    public List<Task> filterTasks(int priority, Date dueDate, User assignedUser) {
        List<Task> results = new ArrayList<Task>();

        for (Task task : tasks) {
            if (task.getPriority() == priority && task.getDueDate().equals(dueDate) && task.getAssignedUser().equals(assignedUser)) {
                results.add(task);
            }
        }

        return results;
    }
}
