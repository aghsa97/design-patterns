package com.mycompany.app.easy.task_manager.commands;

import java.util.Date;

import com.mycompany.app.easy.task_manager.TaskManger;
import com.mycompany.app.easy.task_manager.task.Task;

public class SetReminderCommand extends Command {
    private Date reminder;
    private Task task;
    public SetReminderCommand(TaskManger manager, Date reminder, Task task) {
        super(manager);
        this.reminder = reminder;
        this.task = task;
    }

    @Override
    public void execute() {
        manager.setReminder(reminder, task);
    }
    
}
