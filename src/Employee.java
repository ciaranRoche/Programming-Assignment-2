/**
 * Employee Class for Assignment 2
 * this employee class stores the information for the employee
 * it adds employees to an employee arraylist
 * it calculates salary and over time for employees 
 * it contains getters and setter for employee details
 */

/**
 * @author Ciaran Roche
 * @version 20/4/2016
 */

public abstract class Employee {
	
	protected String firstName;
	protected String secondName;
	protected double hourlyRate;
	
	protected double overTimeWorked;
	
	
	private final static double NORMAL_WORKWEEK = 37.5;
	
	/*Employee() constructor, taking in a string firstname
	 * a string secondName
	 * and a double hourlyRate*/
	
	public Employee(String firstName, String secondName, double hourlyRate){
		this.firstName = firstName;
		this.secondName = secondName;
		this.hourlyRate = hourlyRate;
		
	}
	
	/*employee() blank constructor for the xml file*/
	
	public Employee() {}	
	
	/*calculateSalary()this takes in a double hoursWorked, it checks it against the constant normalWorkingweek
	 * it returns the salary*/
	
	public double calculateSalary(double hoursWorked) {
		if(hoursWorked<=getNormalWorkweek()){
			return ((getHourlyRate()*(hoursWorked))+(calculateOvertime(hoursWorked)));
		}else{
			return ((getHourlyRate()*(getNormalWorkweek()))+(calculateOvertime(hoursWorked)));
		}
	}
		
	/*calculateOvertime() method or calculating overtime
	 * takes in a double, checks to see if it is less than the constant normal workweek
	 * it is it returns nothing, it is is more it finds out how much extra it is over
	 * and doubles the hourly rate for the time over the constant*/
	
	double calculateOvertime(double hoursWorked){
		if(hoursWorked<getNormalWorkweek()){
			return(0.0);
		}else{
			return((getHourlyRate()*2)*(hoursWorked-getNormalWorkweek()));
		}
	}
	
	/*toString() employee too string that returns the firstname, secondname and hourlyRate*/
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate " + hourlyRate;
    }

	/****** getters and setters*******/
	
	public String getFirstName() {
		
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public double getHourlyRate() {
		if(hourlyRate<0){
			return 0;
		}else{
		return hourlyRate;
		}
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
		
	}

	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate<0){
			return;
		}else{
			this.hourlyRate = hourlyRate;
		}
	}

	public static double getNormalWorkweek() {
		return NORMAL_WORKWEEK;
	}




	
}
