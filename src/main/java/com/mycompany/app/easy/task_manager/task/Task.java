package com.mycompany.app.easy.task_manager.task;

import java.util.Date;

import com.mycompany.app.easy.task_manager.User;

public class Task {
    // 2. Each task should have a title, description, 
    // due date, priority, and status
    // (e.g., pending, in progress, completed).

    private final int id;
    private String title;
    private String description;
    private Date due_date;
    private int priority;
    private Status status;
    private User assignedTo;
    private Date reminder;

    public Task(int id, String title, String description, Date due_date, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.priority = priority;
        this.status = Status.PENDING;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return due_date;
    }

    public int getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public User getAssignedUser() {
        return assignedTo;
    }

    public Date getReminder() {
        return reminder;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date due_date) {
        this.due_date = due_date;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAssignedTo(User newAssignedUser) {
        this.assignedTo = newAssignedUser;
    }

    public void setReminder(Date reminder) {
        this.reminder = reminder;
    }
}
