package com.mycompany.app.easy.task_manager.commands;

import com.mycompany.app.easy.task_manager.TaskManger;

public abstract class Command {
    public TaskManger manager;

    Command(TaskManger manager) {
        this.manager = manager;
    }

    public abstract void execute();
}
