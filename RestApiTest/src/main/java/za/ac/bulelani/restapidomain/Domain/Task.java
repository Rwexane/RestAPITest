package za.ac.bulelani.restapidomain.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private  String userName;
    private String taskName;
    private String taskDescription;
    private String taskLevel;


    public long getId() {
        return id;
    }

    public String getTaskName(){
        return taskName;
    }
    public String getUserName(){
        return userName;
    }
    public String getTaskDescription(){
        return taskDescription;
    }
    public String getTaskLevel() { return taskLevel;}

    public Task()
    {

    }

    public Task(Builder builder) {
        id = builder.id;
        userName = builder.userName;
        taskName = builder.taskName;
        taskDescription = builder.taskDescription;
        taskLevel = builder.taskLevel;

    }
    public static class Builder {
        //Equivalent to setters
        private long id;
        private String userName;
        private String taskName;
        private String taskDescription;
        private String taskLevel;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder taskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
            return this;
        }

        public Builder taskLevel(String taskLevel) {
            this.taskLevel = taskLevel;
            return this;
        }

        public Builder copy(Task task){
            this.id = task.getId();
            this.userName = task.getUserName();
            this.taskName = task.getTaskName();
            this.taskDescription = task.getTaskDescription();
            this.taskLevel = task.taskLevel;

            return this;
        }
        public Task build() {
            return new Task(this);
        }
    }


}