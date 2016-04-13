
public class SalesWorker extends Employee {

	private double bonus;

	public SalesWorker(String firstName, String lastName, double hourlyRate, double bonus) {
		super(firstName, lastName, hourlyRate);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
