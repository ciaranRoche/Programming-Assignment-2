import java.util.ArrayList;

/**
 * Manager Class for Assignment 2
 * this manager class stores the information for manager
 * it adds employees to a manager arraylist
 * it calculates salary and bonus for employees in the manager class
 * it extends from the employee class
 */

/**
 * @author Ciaran Roche
 * @version 20/4/2016
 */

public class Manager extends Employee {

	private double bonus;
	
	private ArrayList<Employee> managerEmployees;

	/*manager() constructor for manager taking in string firstname, string secondname, double hourlyrate from the super class
	 * takes in double bonus*/
	
	public Manager(String firstName, String secondName, double hourlyRate, double bonus){
		super(firstName, secondName, hourlyRate );
		this.bonus = bonus;
		
		managerEmployees = new ArrayList<Employee>();
	}
	
	/*manager() blank constructor to get over xml bug1*/
	
	public Manager(){
	}
	
	/*calculateSalary()This method takes in a double hourlyRate and pulls the super.calculateSalary method
	 * and adds a bonus to it*/
	
	public double calculateSalary(double hourlyRate) {
		return ((super.calculateSalary(hourlyRate))+getBonus());
	}
	
	/*getDept()simple getter for employees under a manager*/
	
	public ArrayList<Employee> getDept() {
		return managerEmployees;
	}

	/*numberInDept() method for returning size of managers department*/
	
	public int numberInDept() {
		return managerEmployees.size();
	}

	/*addDeptEmployee() method that adds emplouyess to a department*/
	
	public void addDeptEmployee(Employee employee) {
		managerEmployees.add(employee);
	}
	
	/*setDept() a setter for arraylist Employee tempDepartment*/
	
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

	/*toString() manager tostring that overides the super toostring when called*/
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate: " + hourlyRate
             + ", Bonus: " + bonus + "\n"
             + "           Employees in "+firstName+ "`s Depatment: "+ getDept()+"\n";
    }

	
	








}
