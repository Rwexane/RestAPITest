package za.ac.bulelani.restapidomain.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;


    public User()
    {

    }

    private User(Builder build)
    {
        this.username = build.username;
        this.id = build.id;


    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public static class Builder{
        private long id;
        private String username;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder user(User user) {
            username = user.getUsername();
            id = user.getId();
            return this;
        }

        public Builder copy(User value){
            username = value.username;
            id = value.id;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
