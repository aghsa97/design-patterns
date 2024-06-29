package com.mycompany.app.easy.task_manager.commands;

import com.mycompany.app.easy.task_manager.TaskManger;
import com.mycompany.app.easy.task_manager.User;
import com.mycompany.app.easy.task_manager.task.Task;

public class AssignUserToTaskCommand extends Command {
    private User user;
    private Task task;

    public AssignUserToTaskCommand(TaskManger manager, User user, Task task) {
        super(manager);
        this.task = task;
        this.user = user;
    }

    @Override
    public void execute() {
        manager.assignUserToTask(user, task);
    }
    
}
