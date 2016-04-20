/**
 * TempWorker Class for Assignment 2
 * this class stores the information for tempWorker
 */

/**
 * @author Ciaran Roche
 * @version 20/4/2016
 */

public class TempWorker extends Employee{

	/*TempWorker() Constructor that takes in information needed for the tempworker*/
	
	public TempWorker(String firstName, String secondName, double hourlyRate) {
		super(firstName, secondName, hourlyRate);
	}
	
	/*TempWorker() blank constructor for the xml bug*/
	
	public TempWorker(){
		
	}
	
	/*CalculateSalary() this method returns the super calcSalry method*/

	public double calculateSalary(double hourlyRate) {
		return ((super.calculateSalary(hourlyRate)));
	}
	
	/*toString, basic toSting giving back information from a tempWorker*/
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate " + hourlyRate;
    }

}
