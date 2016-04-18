import java.util.ArrayList;

public class Manager extends Employee {

	private double bonus;
	
	private ArrayList<Employee> managerEmployees;

	public Manager(String firstName, String secondName, double hourlyRate, double bonus){
		super(firstName, secondName, hourlyRate );
		this.bonus = bonus;
		
		managerEmployees = new ArrayList<Employee>();
	}
	
	public double calculateSalary(double hourlyRate) {
		return ((super.calculateSalary(hourlyRate))+getBonus());
	}
	
	public ArrayList<Employee> getDept() {
		return managerEmployees;
	}

	public int numberInDept() {
		return managerEmployees.size();
	}

	public void addDeptEmployee(Employee employee) {
		managerEmployees.add(employee);
	}
	
	
	public void setDept(ArrayList<Employee> tempDepartment) {
		this.managerEmployees = tempDepartment;
		
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

	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate: " + hourlyRate
             + ", Bonus: " + bonus
             + ", Employees in Depatment:\n"+ getDept();
    }

	
	








}
