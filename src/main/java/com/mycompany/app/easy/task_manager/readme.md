# Designing a Task Management System

## Requirements

1. The task management system should allow users to create, update, and delete tasks.
2. Each task should have a title, description, due date, priority, and status (e.g., pending, in progress, completed).
3. Users should be able to assign tasks to other users and set reminders for tasks.
4. The system should support searching and filtering tasks based on various criteria (e.g., priority, due date, assigned user).
5. Users should be able to mark tasks as completed and view their task history.
6. The system should handle concurrent access to tasks and ensure data consistency.
7. The system should be extensible to accommodate future enhancements and new features.

## To run it

```bash
mvn clean install
java -cp target/design-patterns-1.0-SNAPSHOT.jar com.mycompany.app.easy.task_manager.Main
```

## Design

- Task management system is designed using the Command design pattern.
- The system consists of the following components:
  - Task: Represents a task with a title, description, due date, priority, and status.
  - TaskManager: Manages tasks and provides operations to create, update, delete, assign, and search tasks.
  - TaskCommand: Represents a command to perform an operation on a task.
  - TaskInvoker: Invokes a task command to execute an operation on a task.
  - TaskHistory: Maintains a history of tasks and their operations.
  - TaskFilter: Filters tasks based on various criteria (e.g., priority, due date, assigned user).
  - TaskReminder: Sends reminders for tasks.
  - TaskStatus: Represents the status of a task (e.g., pending, in progress, completed).
  - TaskPriority: Represents the priority of a task (e.g., low, medium, high).
  - TaskUser: Represents a user who can be assigned tasks.
  - TaskException: Represents an exception that can occur during task operations.
  - TaskUtils: Provides utility methods for tasks (e.g., date formatting).
