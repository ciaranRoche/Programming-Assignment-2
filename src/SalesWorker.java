
public class SalesWorker extends Employee {

	private double bonus;

	public SalesWorker(String firstName, String secondName, double hourlyRate, double bonus) {
		super(firstName, secondName, hourlyRate);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate " + hourlyRate
             + ", Bonus: " + bonus;      	
    }

}
