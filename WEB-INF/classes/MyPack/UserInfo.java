package MyPack;

import java.io.*;

public class UserInfo implements Serializable{
    String email;
    String username;
    String password;
    String phone;
    String jobId;
    String userType;
    public UserInfo(){
        this.email = "";
        this.username = "";
        this.password = "";
        this.phone = "";
        this.jobId = "";
        this.userType = "";
    }
    public void setEmail(String email){
        this.email = email;
    }

     public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setJobId(String jobId){
        this.jobId = jobId;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getPhone(){
        return phone;
    }

    public String getJobId(){
        return jobId;
    }

    public String getUserType(){
        return userType;
    }
}
