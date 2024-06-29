package com.mycompany.app.easy.task_manager.commands;

import com.mycompany.app.easy.task_manager.TaskManger;

public class MarkTaskAsCompletedCommand extends Command{
    private int taskId;

    public MarkTaskAsCompletedCommand(TaskManger manger, int taskId) {
        super(manger);
        this.taskId = taskId;
    }

    @Override
    public void execute() {
        manager.markTaskAsCompleted(taskId);
    }
    
}
