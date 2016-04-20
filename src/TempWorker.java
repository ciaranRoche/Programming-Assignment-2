
public class TempWorker extends Employee{

	public TempWorker(String firstName, String secondName, double hourlyRate) {
		super(firstName, secondName, hourlyRate);
	}
	
	public TempWorker(){
		
	}

	public double calculateSalary(double hourlyRate) {
		return ((super.calculateSalary(hourlyRate)));
	}
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate " + hourlyRate;
    }

}
