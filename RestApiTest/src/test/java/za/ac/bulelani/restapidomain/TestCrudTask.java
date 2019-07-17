/*package za.ac.cput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.annotations.Test;
import za.ac.cput.domain.Task;
import za.ac.cput.domain.Dog;
import za.ac.cput.factories.taskFactory.TaskFactory;
import za.ac.cput.factories.dog.DogFactory;
import za.ac.cput.repository.task.TaskRepo;
import za.ac.cput.repository.dog.DogRepo;
import za.ac.cput.services.task.TaskService;


@SpringApplicationConfiguration(classes =App.class)
@WebAppConfiguration
public class TestCrudTask  extends AbstractTestNGSpringContextTests {

    @Autowired
    TaskRepo myrepo;
    private long id;


    @Test
    public void create() throws Exception
    {
        Task task = TaskFactory.createTask("Horsy","Innocent","Mphokeli","July 2018");
        myrepo.save(task);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {

    }


}*/

