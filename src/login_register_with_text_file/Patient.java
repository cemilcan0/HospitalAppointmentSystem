package login_register_with_text_file;

import java.io.*;

public class Patient implements Serializable {
    private String name;
    private String ıd;
    private String age;
    private String password;
    private String email;
    private String confirmpassword;
    
    public Patient(){
    
    }

    public Patient(String ıd,String name,String age,String email ,String password) {
        this.name = name;
        this.ıd = ıd;
        this.age = age;
        this.email = email;
        this.password = password;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getıd() {
        return ıd;
    }

    public void setıd(String ıd) {
        this.ıd = ıd;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    
    
    
}