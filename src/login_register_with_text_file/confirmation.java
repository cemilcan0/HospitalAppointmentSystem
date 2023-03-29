
package login_register_with_text_file;


public class confirmation extends Patient{
    
    private String date;
    private String clinic;
    
    public confirmation(){

    
    }

    public confirmation(String date, String clinic, String ıd, String name, String age, String email, String password) {
        super(ıd, name, age, email, password);
        this.date = date;
        this.clinic = clinic;
    }

    public confirmation(String date, String clinic) {
        this.date = date;
        this.clinic = clinic;
    }

    public String getDate() {
        return date;
    }

    public String getClinic() {
        return clinic;
    }
    
}
