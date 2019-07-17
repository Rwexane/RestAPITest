package za.ac.bulelani.restapidomain.Factories;

import za.ac.bulelani.restapidomain.Domain.Task;

public class TaskFactory {
    public static Task createTask(String userName, String taskName,
                                      String taskDescription, String taskLevel)
    {
        Task task = new Task.Builder()
                .userName(userName)
                .taskName(taskName)
                .taskDescription(taskDescription)
                .taskLevel(taskLevel)
                .build();
        return task;
    }
}
