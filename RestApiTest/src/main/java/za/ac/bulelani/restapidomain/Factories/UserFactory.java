package za.ac.bulelani.restapidomain.Factories;

import za.ac.bulelani.restapidomain.Domain.User;

public class UserFactory {


    public static User createUser(String username)
    {
        return new User.Builder()
                .username(username)
                .build();
    }

}
