package za.ac.bulelani.restapidomain.Repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.bulelani.restapidomain.Domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findOne(Long id);
}
