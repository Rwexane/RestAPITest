package za.ac.bulelani.restapidomain.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.bulelani.restapidomain.Domain.User;
import za.ac.bulelani.restapidomain.services.user.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService myService;


    //--------------------------------------Create Client------------------------------------
    @RequestMapping(value = "/user/create", method = RequestMethod.PUT)
    public ResponseEntity<Void> createClient(@RequestBody User user, UriComponentsBuilder ucBuilder)
    {
        myService.create(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Story--------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        User user = myService.readById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    //---------------------Retrieve List of Clients---------------------------------------------------
    @RequestMapping(value = "/users/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllClients()
    {
        List<User> users = myService.readAll();
        if(users.isEmpty())
        {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//OR HttpStatus.Not_Found
        }
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id")long id)
    {
        System.out.println("Fetching & Deleting User with id" + id);

        User user = myService.readById(id);
        if(user == null)
        {
            System.out.println("Unable to delete. User with id " + id + " not found");//comment
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        myService.delete(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    //----------------------------------Update----------------------------------------------------
    @RequestMapping(value = "User/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user)
    {
        System.out.println("Updating User " + id);

        User currentUser = myService.readById(id);

        if(currentUser == null)
        {
            System.out.println("User with id" +id+ "not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        User updatedUser = new User.Builder().copy(currentUser)
                .id(user.getId())
                .username(user.getUsername())
                .build();
        myService.update(updatedUser);

        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }
}
