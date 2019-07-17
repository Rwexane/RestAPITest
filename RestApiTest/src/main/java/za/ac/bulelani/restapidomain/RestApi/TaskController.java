package za.ac.bulelani.restapidomain.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.bulelani.restapidomain.Domain.Task;
import za.ac.bulelani.restapidomain.services.user.TaskService;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService myService;
    //--------------------------------------Create Task------------------------------------
    @RequestMapping(value = "/task/create", method = RequestMethod.PUT)
    public ResponseEntity<Void> createTask(@RequestBody Task task, UriComponentsBuilder ucBuilder)
    {
        myService.create(task);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/task/{id}").buildAndExpand(task.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    //-------------------Retrieve Single Task--------------------------------------------------------
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable("id") long id) {
        Task task = myService.readById(id);
        if (task == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    //---------------------Retrieve List of Tasks---------------------------------------------------
    @RequestMapping(value = "/tasks/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getAllAdoptops()
    {
        List<Task> clients = myService.readAll();
        if(clients.isEmpty())
        {
            return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);//OR HttpStatus.Not_Found
        }

        return new ResponseEntity<List<Task>>(clients,HttpStatus.OK);
    }

    @RequestMapping(value = "/task/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Task> deleteTask(@PathVariable("id")long id)
    {
        System.out.println("Fetching & Deleting Task with id" + id);

        Task task = myService.readById(id);
        if(task == null)
        {
            System.out.println("Unable to delete. Task with id " + id + " not found");//comment
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);

        }

        myService.delete(task);
        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
    }

    //----------------------------------Update----------------------------------------------------
    @RequestMapping(value = "Task/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task)
    {
        System.out.println("Updating Task " + id);

        Task currentTask = myService.readById(id);

        if(currentTask == null)
        {
            System.out.println("Task with id" +id+ "not found");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }

        Task updatedTask = new Task.Builder().copy(currentTask)
                .id(task.getId())
                .userName(task.getUserName())
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .taskLevel(task.getTaskLevel())
                .build();
        myService.update(updatedTask);

        return new ResponseEntity<Task>(updatedTask,HttpStatus.OK);
    }
}
