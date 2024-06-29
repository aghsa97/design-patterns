package com.mycompany.app.easy.task_manager.commands;

import com.mycompany.app.easy.task_manager.TaskManger;
import com.mycompany.app.easy.task_manager.task.Task;

public class UpdateTaskCommand extends Command {
    private Task task;

    public UpdateTaskCommand(TaskManger manager, Task task) {
        super(manager);
        this.task = task;
    }

    @Override
    public void execute() {
        manager.updateTask(task);
    }
}
