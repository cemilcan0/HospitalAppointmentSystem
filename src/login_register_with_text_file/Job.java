
package login_register_with_text_file;

import java.io.*;

public class Job implements Serializable{
    private double salary;
    private String jobName;

    public Job(double salary, String jobName) {
        this.salary = salary;
        this.jobName = jobName;
    }
    
    public boolean equals(Job job){
        return (this.salary == job.salary && 
                this.jobName.equals(job.jobName));
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
}
