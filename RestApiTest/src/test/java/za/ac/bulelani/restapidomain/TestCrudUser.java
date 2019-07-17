/* package za.ac.bulelani.restapidomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.bulelani.restapidomain.Domain.User;
import za.ac.bulelani.restapidomain.Factories.UserFactory;
import za.ac.bulelani.restapidomain.Repository.user.UserRepository;
import za.ac.bulelani.restapidomain.services.user.UserService;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringApplicationConfiguration(classes =App.class)
@WebAppConfiguration

public class TestCrudUser  extends AbstractTestNGSpringContextTests{

    private long id;

    @Autowired
    UserService myrepo;


    @Test
    public void create() throws Exception
    {
        User myUser = UserFactory.createUser("Bulelani");
        myrepo.create(myUser);
    }



    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {

    }



}*/