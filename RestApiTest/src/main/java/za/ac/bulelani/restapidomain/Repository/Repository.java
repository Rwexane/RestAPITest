package za.ac.bulelani.restapidomain.Repository;

import java.util.Set;

public interface Repository <E, ID>  {


    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();

}