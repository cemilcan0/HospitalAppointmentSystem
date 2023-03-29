package login_register_with_text_file;

import java.io.*;

public class Doctor extends Patient{
        public String department;
        public String age;
        public String location;
        
    public Doctor(){
        // default constructor

}
        
    public Doctor(String department, String name,String age,String ıd, String password,String location,String email) {
        super(ıd, name,age,email,password);
        this.department = department;
        this.location   = location;
    }

        
    

    public String getlocation() {
        return location;
    }
    

    public String getDepartment() {
        return department;
    }
    
   
   
    @Override
    public String toString() {
        return "Doctor{" + "department=" + department + ", age=" + age + ", location=" + location + '}';
    }
    
}
