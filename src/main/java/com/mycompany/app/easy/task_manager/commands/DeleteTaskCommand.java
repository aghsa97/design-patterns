package com.mycompany.app.easy.task_manager.commands;

import com.mycompany.app.easy.task_manager.TaskManger;

public class DeleteTaskCommand extends Command {
    private int taskId;

    public DeleteTaskCommand(TaskManger manager, int taskId) {
        super(manager);
        this.taskId = taskId;
    }

    @Override
    public void execute() {
        manager.deleteTask(taskId);
    }
}
