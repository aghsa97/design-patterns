package com.mycompany.app.easy.task_manager;

import java.util.Date;
import java.util.List;

import com.mycompany.app.easy.task_manager.commands.AssignUserToTaskCommand;
import com.mycompany.app.easy.task_manager.commands.CreateTaskCommand;
import com.mycompany.app.easy.task_manager.commands.DeleteTaskCommand;
import com.mycompany.app.easy.task_manager.commands.UpdateTaskCommand;
import com.mycompany.app.easy.task_manager.task.Task;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        
        TaskManger manager = TaskManger.getInstance();
        User mohammed = new User(0);
        User khaled = new User(1);

        Task firstTask = new Task(0, "Finish the course.", "Finish design patterns course.", new Date(),1);
        Task secondTask = new Task(1, "Learn Java.", "Learn Java by practicing the course.", new Date(), 0);
        Task thirdTask = new Task(2, "Go to gym.", "Follow your plan by going to the gym.", new Date(), 0);

        CreateTaskCommand createTask = new CreateTaskCommand(manager, firstTask);
        CreateTaskCommand createTask2 = new CreateTaskCommand(manager, secondTask);
        CreateTaskCommand createTask3 = new CreateTaskCommand(manager, thirdTask);

        createTask.execute();
        createTask2.execute();
        createTask3.execute();

        AssignUserToTaskCommand assigner = new AssignUserToTaskCommand(manager, mohammed, firstTask);
        AssignUserToTaskCommand assigner2 = new AssignUserToTaskCommand(manager, khaled, secondTask);
        AssignUserToTaskCommand assigner3 = new AssignUserToTaskCommand(manager, khaled, thirdTask);
        assigner.execute();
        assigner2.execute();
        assigner3.execute();

        System.out.println("History: ");
        List<Task> userHistory = manager.viewHistory(mohammed);
        for (Task task : userHistory) {
            System.out.println(task.getTitle());
        }

        System.out.println("History: ");
        List<Task> khaledHistory = manager.viewHistory(khaled);
        for (Task task : khaledHistory) {
            System.out.println(task.getTitle());
        }
        
        firstTask.setDescription("updated task");
        UpdateTaskCommand updater = new UpdateTaskCommand(manager, firstTask);
        updater.execute();
        
        System.out.println("History: ");
        List<Task> userHistory2 = manager.viewHistory(mohammed);
        for (Task task : userHistory2) {
            System.out.println(task.getTitle() + task.getDescription());
        }
        
        // Search tasks
        List<Task> searchResults = manager.searchTasks("course");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        AssignUserToTaskCommand assigner4 = new AssignUserToTaskCommand(manager, mohammed, thirdTask);
        assigner4.execute();

        // Filter tasks
        List<Task> filteredTasks = manager.filterTasks(1, new Date(), mohammed);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as completed
        manager.markTaskAsCompleted(0);

        // Get task history for a user
        List<Task> taskHistory = manager.viewHistory(mohammed);
        System.out.println("Task History for user with id " + mohammed.getId() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle() + " " + task.getPriority() + " " + task.getStatus());
        }

        // Delete a task
        DeleteTaskCommand deleter = new DeleteTaskCommand(manager, 0);
        deleter.execute();

        System.out.println("History: ");
        List<Task> mohammedHistory = manager.viewHistory(khaled);
        for (Task task : mohammedHistory) {
            System.out.println(task.getTitle());
        }
    }
}
