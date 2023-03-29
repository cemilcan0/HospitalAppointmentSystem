
package login_register_with_text_file;

public class MainClass {
    /*  To add a doctor, the Admin Page must be entered. Admin page username=Admin,password=8080
        Only administrators can give the password to doctors. Doctors must enter the login 
    doctor page to enter the system and add an appointment. they can only set appointment times for the next 7 days.
    Patients can log in at the patient entrance and register to the system from the registration section there.
    After logging into the system, patients can find the nearest hospital to them via GPS if they wish.
    patients can choose a date after choosing the region, polyclinic and doctor name (they can only take action within the next 7 days)
    If, after the date selection, there is no text in the place where the clocks are written, it means that the doctor did not add to that
    date. If green or red checkboxes appear, you can select a time and make an appointment.
    Only one department can make an appointment once and the appointment at that time is closed.
    
    
    
    
    */
    public static void main(String[] args) {
    new Users_select().setVisible(true);
    
}
}