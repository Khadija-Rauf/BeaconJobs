package MyPack;

import java.io.*;

public class JobInfo implements Serializable{
    String id;
    String title;
    Integer salary;
    String type;
    String description;
    public JobInfo(){
        this.id = "";
        this.title = "";
        this.salary = 0;
        this.type = "";
        this.description = "";
    }
    public void setId(String id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

     public void setSalary(Integer salary){
        this.salary = salary;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    public Integer getSalary(){
        return salary;
    }

    public String getType(){
        return type;
    }

    public String getDescription(){
        return description;
    }

}
