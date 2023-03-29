package login_register_with_text_file;
import java.io.Serializable;



import java.io.*;

public class Checkbox implements Serializable{

    public String days;
    public String name;
    public String checkbox1;
    public String checkbox2;
    public String checkbox3;
    public String checkbox4;
    public String checkbox5;
    public String checkbox6;
    public String checkbox7;
    public String checkbox8;
    public String checkbox9;
    public String checkbox10;
    public String checkbox11;
    public String checkbox12;

    public Checkbox(){
        // default constructor
    }


    
    public Checkbox(String days,String name,String checkbox1,String checkbox2,String checkbox3,String checkbox4,String checkbox5,String checkbox6,String checkbox7
    ,String checkbox8,String checkbox9,String checkbox10,String checkbox11,String checkbox12) {
        this.days=days;
        this.name=name;
        this.checkbox1=checkbox1;
        this.checkbox2=checkbox2;
        this.checkbox3=checkbox3;
        this.checkbox4=checkbox4;
        this.checkbox5=checkbox5;
        this.checkbox6=checkbox6;
        this.checkbox7=checkbox7;
        this.checkbox8=checkbox8;
        this.checkbox9=checkbox9;
        this.checkbox10=checkbox10;
        this.checkbox11=checkbox11;
        this.checkbox12=checkbox12;
        
        
    }

 
    
    
   
    

    public String getCheckbox1() {
        return checkbox1;
    }

    public String getCheckbox2() {
        return checkbox2;
    }

    public String getCheckbox3() {
        return checkbox3;
    }

    public String getCheckbox4() {
        return checkbox4;
    }

    public String getCheckbox5() {
        return checkbox5;
    }

    public String getCheckbox6() {
        return checkbox6;
    }

    public String getCheckbox7() {
        return checkbox7;
    }

    public String getCheckbox8() {
        return checkbox8;
    }

    public String getCheckbox9() {
        return checkbox9;
    }

    public String getCheckbox10() {
        return checkbox10;
    }

    public String getCheckbox11() {
        return checkbox11;
    }

    public String getCheckbox12() {
        return checkbox12;
    }

    public String getName() {
        return name;
    }
     public String getDays() {
        return days;
    }
    
    

    
}
