import java.util.ArrayList;

public class Employee {
	
	protected String firstName;
	protected String secondName;
	protected double hourlyRate;
	
	protected double hoursWorked;
	protected double overTimeWorked;
	
	private static ArrayList<String> employees;
	
	final static double NORMAL_WORKWEEK = 37.5;
	
	public Employee(String firstName, String secondName, double hourlyRate){
		this.firstName = firstName;
		this.secondName = secondName;
		this.hourlyRate = hourlyRate;
		
		employees =new ArrayList<String>();
		
	}
	
	public double calculateSalary(double hoursWorked) {
		if(hoursWorked<=NORMAL_WORKWEEK){
			return ((getHourlyRate()*(hoursWorked))+(calculateOvertime(hoursWorked)));
		}else{
			return ((getHourlyRate()*(NORMAL_WORKWEEK))+(calculateOvertime(hoursWorked)));
		}
	}
		
	
	private double calculateOvertime(double hoursWorked){
		if(hoursWorked<NORMAL_WORKWEEK){
			return(0.0);
		}else{
			return((getHourlyRate()*2)*(hoursWorked-NORMAL_WORKWEEK));
		}
	}
	
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate " + hourlyRate;
    }

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

	public static ArrayList<String> getEmployees() {
		return employees;
	}

	public static void setEmployees(ArrayList<String> employees) {
		Employee.employees = employees;
	}




	
}
