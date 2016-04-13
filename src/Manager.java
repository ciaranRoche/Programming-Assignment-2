import java.util.ArrayList;

public class Manager extends Employee {

	private double bonus;
	
	private ArrayList<Manager> managerEmployees;

	public Manager(String firstName, String lastName, double hourlyRate, double bonus){
		super(firstName, lastName, hourlyRate );
		this.bonus = bonus;
	}
	
	public double calculateSalary(double hourlyRate) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<Employee> getDept() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object numberInDept() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addDeptEmployee(SalesWorker sales1) {
		// TODO Auto-generated method stub
		
	}
	

	public void addDeptEmployee(TempWorker temp1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDept(ArrayList<Employee> tempDepartment) {
		// TODO Auto-generated method stub
		
	}

	/*** getters and setters **/

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}



	public ArrayList<Manager> getManagerEmployees() {
		return managerEmployees;
	}

	public void setManagerEmployees(ArrayList<Manager> managerEmployees) {
		this.managerEmployees = managerEmployees;
	}


	
	








}
