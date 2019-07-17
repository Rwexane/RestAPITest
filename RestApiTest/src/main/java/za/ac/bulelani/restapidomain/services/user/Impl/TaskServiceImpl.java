package za.ac.bulelani.restapidomain.services.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.bulelani.restapidomain.Domain.Task;
import za.ac.bulelani.restapidomain.services.user.TaskService;
import za.ac.bulelani.restapidomain.Repository.user.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository repository;

    @Override
    public Task create(Task entity) {
        return repository.save(entity);
    }

    @Override
    public Task readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Task> readAll(){

        List<Task> taskList = new ArrayList<Task>();
        Iterable<Task>tasks = repository.findAll();
        for(Task task : tasks) {
            taskList.add(task);
        }
        return taskList;
    }

    @Override
    public Task update(Task entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Task entity) {
        repository.delete(entity);

    }
}
