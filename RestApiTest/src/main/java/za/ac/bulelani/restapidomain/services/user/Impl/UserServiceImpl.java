package za.ac.bulelani.restapidomain.services.user.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.bulelani.restapidomain.Domain.User;
import za.ac.bulelani.restapidomain.Repository.user.UserRepository;
import za.ac.bulelani.restapidomain.services.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> readAll()
    {
        List<User>  userList = new ArrayList<User>();
        Iterable<User> users = repository.findAll();
        for (User client : users) {
            userList.add(client);
        }
        return userList;
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);

    }
}
