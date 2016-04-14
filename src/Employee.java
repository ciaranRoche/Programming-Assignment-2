import java.util.ArrayList;

public class Employee {
	
	protected String firstName;
	protected String lastName;
	protected double hourlyRate;
	
	protected double hoursWorked;
	protected double overTimeWorked;
	
	final static double NORMAL_WORKWEEK = 37.5;
	
	public Employee(String firstName, String lastName, double hourlyRate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
		//this.overTimeWorked = overTimeWorked;
		
		
	}
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + lastName
             + ", Hourly Rate " + hourlyRate;
    }

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getSecondName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double getHourlyRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	public void setSecondName(String lastName) {
		this.lastName = lastName;
		
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
		
	}


	
}
