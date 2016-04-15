import java.util.ArrayList;

public class Manager extends Employee {

	private double bonus;
	
	private ArrayList<Manager> managerEmployees;

	public Manager(String firstName, String secondName, double hourlyRate, double bonus){
		super(firstName, secondName, hourlyRate );
		this.bonus = bonus;
	}
	
	public double calculateSalary(double hourlyRate) {
		return ((super.calculateSalary(hourlyRate))+getBonus());
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
		if(bonus<0){
			return 0;
		}else{
			return bonus;
		}
	}

	public void setBonus(double bonus) {
		if(bonus<0){
			return;
		}else{
			this.bonus = bonus;
		}
	}



	public ArrayList<Manager> getManagerEmployees() {
		return managerEmployees;
	}

	public void setManagerEmployees(ArrayList<Manager> managerEmployees) {
		this.managerEmployees = managerEmployees;
	}
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate: " + hourlyRate
             + ", Bonus: " + bonus;
    }

	
	








}
