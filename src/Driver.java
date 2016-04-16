
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class Driver {
	
	Employee employee;
	private Scanner input;
	private static ArrayList<Employee> employees;
	
	public double hoursWorked;
	public double totalSalary = 0;
	
	public Driver(){
		input = new Scanner(System.in);
	}
	
	public static void main(String args[])
	{
		Driver app = new Driver();
		employees = new ArrayList<Employee>();
		app.run();
		
	}
	
    private void run(){
		int option = menu();
		while(option != 0){
			switch (option){
			case 1:
				addEmployeeChoices();
				break;
			case 2:
				System.out.println(listEmployees());
				break;
			case 3:
				//
				break;
			case 4:
				calcWages();
				break;
			case 5:
				totalSalary();
				break;
			}
			System.out.println("");
			option = menu();
		}		
		System.out.println("Exiting, have a nice day.");
		System.out.println("GoodBye!");
	}
    
    private int menu(){
    	System.out.println("Employee index/payroll");
    	System.out.println("Please select the number of the option you want below");
    	System.out.println("   1) Add a new Employee");
    	System.out.println("   2) List Employees");
    	System.out.println("   3) Edit Employee Departments");
    	System.out.println("   4) Calculate Employee Salaries");
    	System.out.println("   5) Total Salary to date");

    	System.out.println("========");
    	System.out.println("   0) Exit");
    	System.out.println("====>>>>");
    	int choice = input.nextInt();
    	return choice;
    }
    
    private void addEmployeeChoices(){
    	int option = addEmployeeMenu();
		while(option != 0){
			switch (option){
			case 1:
				addManager();
				break;
			case 2:
				addSalesWorker();
				break;
			case 3:
				addTempWorker();
				break;
			case 4:
				run();
				break;
			}
			System.out.println("");
			option = addEmployeeMenu();
		}		
		System.out.println("Exiting, have a nice day.");
		System.out.println("GoodBye!");
	}
    
    private int addEmployeeMenu(){
    	System.out.println("Please choose Employee Role:");
    	System.out.println("========");
    	System.out.println("   1) Manager");
    	System.out.println("   2) Sales Worker");
    	System.out.println("   3) Temp Worker");
    	System.out.println("========");
    	System.out.println("   4) Go Back");
    	System.out.println("========");
    	System.out.println("   0) Exit");
    	System.out.println("====>>>>");
    	
		int choice = input.nextInt();
    	return choice;   	
    }
  
    
    private void calcWages(){
    	System.out.println(listEmployees());
    	
    	if (getEmployees().size() != 0){
    		System.out.print("Index of employees ==>");
    		int index = input.nextInt();
    		
    		if (index < getEmployees().size()){	
				
    			System.out.print("Enter hours worked this week ");
				hoursWorked = input.nextDouble();
				
				//employee.calculateOvertime(hoursWorked);
				employee = getEmployees().get(index);
				System.out.println(employee.calculateSalary(hoursWorked));
				
				totalSalary = totalSalary + employee.calculateSalary(hoursWorked);
				
				
			}
			else
			{
				System.out.println("There is no Employee for this index number");
				System.out.println("Please choose another index number:");
				calcWages();
			}
		}
	} 
    
    private void totalSalary(){
    	if(totalSalary<=0){
    		System.out.println("There is no salaries calculated");
    	}else{
    		System.out.println("The total calculated salary to date is: " + totalSalary);
    	}
    }
    	
    
    private void addTempWorker() {
    	System.out.println("Please enter Employee first name:");
    	input.nextLine();
    	String firstName = input.nextLine();
    	System.out.println("Please enter Employee surname:");
    	String lastName = input.nextLine();
    	System.out.println("Please enter Employee hourly rate:");
    	Double hourlyRate = input.nextDouble();
    	employees.add(new TempWorker(firstName, lastName, hourlyRate));	
	}

	private void addSalesWorker() {
		System.out.println("Please enter Employee first name:");
		input.nextLine();
    	String firstName = input.nextLine();
    	System.out.println("Please enter Employee surname:");
    	String lastName = input.nextLine();
    	System.out.println("Please enter Employee hourly rate:");
    	Double hourlyRate = input.nextDouble();
    	System.out.println("Please enter Employee Bonus:");
    	Double bonus = input.nextDouble();
    	employees.add(new SalesWorker(firstName, lastName, hourlyRate, bonus));
		
	}

	private void addManager() {
		System.out.println("Please enter Managers first name:");
		input.nextLine();
		String firstName = input.nextLine();
		System.out.println("Please enter Managers surname:");
		String lastName = input.nextLine();
		System.out.println("Please enter Managers hourly rate:");
		Double hourlyRate = input.nextDouble();
		System.out.println("Please enter Managers Bonus:");
		Double bonus = input.nextDouble();
		employees.add(new Manager(firstName, lastName, hourlyRate, bonus));
		
	}
	
	public String listEmployees()
	{
		if (employees.size() == 0)
		{
			return "No Employees!";
		}
		else
		{
			String listEmployees = "";
			for (int i = 0; i < employees.size(); i++)
			{
				listEmployees = listEmployees + (i + ":" + employees.get(i)) + "\n";
			}
			return listEmployees;
		}
		
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	

}
