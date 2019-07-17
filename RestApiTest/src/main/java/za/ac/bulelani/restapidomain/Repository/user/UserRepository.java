package za.ac.bulelani.restapidomain.Repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.bulelani.restapidomain.Domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findOne(Long id);
}
