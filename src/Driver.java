
 
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
				try{
				addEmployeeDept();
				}catch (Exception e){
					System.out.println("Error: "+e);
				}
				break;
			case 4:
				try{
				calcWages();
				}catch (Exception e){
					System.out.println("Error "+e);
				}
				break;
			case 5:
				totalSalary();
				break;
			case 6:
				editEmployee();
				break;
			case 7:
				fireEmployee();
				break;
			case 8:
				try{
					load();
				}
				catch(Exception e){
					System.out.println("Error writing to file: " + e);
				}
				break;
			case 9: 
				try{
					save();
				}
				catch(Exception e){
					System.out.println("Error reading from file: " + e);
				}
				break;
			default:   
				System.out.println("Invalid option entered: " + option);
             break;
			}
			System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            
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
    	System.out.println("   3) Add an Employee to a Department");
    	System.out.println("   4) Calculate Employee Salaries");
    	System.out.println("   5) Total Salary to date");
    	System.out.println("   6) Edit Employees Details" );
    	System.out.println("   7) Remove Employee from system");
    	System.out.println("========");
    	System.out.println("   8) load");
    	System.out.println("   9) save");
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
				try{
				addManager();
				}catch (Exception e){
					System.out.println("Error: "+e);
				}
				break;
			case 2:
				try{
				addSalesWorker();
				}catch (Exception e){
					System.out.println("Error: "+e);
				}
				break;
			case 3:
				try{
				addTempWorker();
				}catch (Exception e){
					System.out.println("Error: "+e);
				}
				break;
			case 4:
				run();
				break;
			default:   
				System.out.println("Invalid option entered: " + option);
             break;
			}
			System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            
			option = addEmployeeMenu();
		}		
	}
    
    private int addEmployeeMenu(){
    	System.out.println("Please choose Employee Role:");
    	System.out.println("========");
    	System.out.println("   1) Manager");
    	System.out.println("   2) Sales Worker");
    	System.out.println("   3) Temp Worker");
    	System.out.println("========");
    	System.out.println("   4) Go Back");
    	System.out.println("====>>>>");
    	
		int choice = input.nextInt();
    	return choice;   	
    }
  
    private void addEmployeeDept(){
    	System.out.println("Please choose an Employee to add to a department from the index:\n");
    	System.out.println(listEmployees());
    	
    	if(getEmployees().size() != 0){
    		System.out.println("Index of employees ==>");
    		int employeeChoice = input.nextInt();
    		System.out.println("Please choose the Manager of a department from the index:\n");
    		System.out.println(listEmployees());
    		int managerChoice = input.nextInt();
    		
    		Employee employee = employees.get(managerChoice);
    		
    		if(employee.getClass().equals(Manager.class)){
    			Manager manager = (Manager) employees.get(managerChoice);
    			
    			manager.addDeptEmployee(employees.get(employeeChoice));
    			//System.out.println(manager.getDept().get(0).firstName);
    			System.out.println("Employee:"+employees.get(employeeChoice).firstName+" has been added to: "+manager.firstName +"`s Department.");
    		}else{
    			System.out.println("You did not choose a Manager");
    			System.out.println("Please start over\n=======");
    			addEmployeeDept();
    		}
		
    	}
    	else{
    		System.out.println("There is no Employee for this index number");
			System.out.println("Please choose another index number:");
			addEmployeeDept();
    	}
    }
    
	public void editEmployee()
	{
		System.out.println(listEmployees());

		if (getEmployees().size() != 0){	
			System.out.print("Index of Emplyees to edit ==>");
			int choice = input.nextInt();
			
			Employee employee = employees.get(choice);
			
			if (choice < getEmployees().size()){
				if(employee.getClass().equals(Manager.class)){
					System.out.println("Please enter Managers first name:");
					input.nextLine();
					String firstName = input.nextLine();
					System.out.println("Please enter Managers surname:");
					String lastName = input.nextLine();
					System.out.println("Please enter Managers hourly rate:");
					Double hourlyRate = input.nextDouble();
					System.out.println("Please enter Managers Bonus:");
					Double bonus = input.nextDouble();
					
					Employee employeeChoice = new Manager(firstName, lastName, hourlyRate, bonus);
					
					employees.set(choice, employeeChoice);
				}else if(employee.getClass().equals(SalesWorker.class)){
					System.out.println("Please enter Employee first name:");
					input.nextLine();
			    	String firstName = input.nextLine();
			    	System.out.println("Please enter Employee surname:");
			    	String lastName = input.nextLine();
			    	System.out.println("Please enter Employee hourly rate:");
			    	Double hourlyRate = input.nextDouble();
			    	System.out.println("Please enter Employee Bonus:");
			    	Double bonus = input.nextDouble();
			    	
			    	Employee employeeChoice = new SalesWorker(firstName, lastName, hourlyRate, bonus);
			    	
			    	employees.set(choice, employeeChoice);
				}else if(employee.getClass().equals(TempWorker.class)){
					System.out.println("Please enter Employee first name:");
			    	input.nextLine();
			    	String firstName = input.nextLine();
			    	System.out.println("Please enter Employee surname:");
			    	String lastName = input.nextLine();
			    	System.out.println("Please enter Employee hourly rate:");
			    	Double hourlyRate = input.nextDouble();
			    	
			    	Employee employeeChoice = new TempWorker(firstName, lastName, hourlyRate);
					
					employees.set(choice, employeeChoice);
				}
			}
			else
			{
				System.out.println("There is no Employee for this index number");
			}
		}
	}
	
	public void fireEmployee()
	{
		System.out.println(listEmployees());

		if (getEmployees().size() != 0){	
			//only process the delete if DVDs exist in the ArrayList
			System.out.print("Please choose index number of employee to remove from the system ==>");
			int fire = input.nextInt();

			if (fire < getEmployees().size()){	
				//if the index number exists in the ArrayList, delete it from the ArrayList
				getEmployees().remove(fire);
				System.out.println("Employee has been removed from the system.");
			}
			else
			{
				System.out.println("There is no Employee for the index number you have chosen");
			}
		}
	} 


    private void calcWages(){
    	System.out.println(listEmployees());
    	
    	if (getEmployees().size() != 0){
    		System.out.print("Index of employees ==>");
    		int index = input.nextInt();
    		
    		if (index < getEmployees().size()){	
				
    			System.out.print("Enter hours worked this week ");
				hoursWorked = input.nextDouble();
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
    	int option = salaryMenu();
		while(option != 0){
			switch (option){
			case 1:
				totalSalaryInt();
				break;
			case 2:
				clearSalary();
				break;
			case 3:
				run();
			default:   
				System.out.println("Invalid option entered: " + option);
             break;
			}
			System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            
			option = salaryMenu();
		}		
	}
    	
    
    private int salaryMenu() {
        	System.out.println("Employee Total Salary Menu");
        	System.out.println("Please select the number of the option you want below");
        	System.out.println("   1) Total Salary to Date");
        	System.out.println("   2) Clear Salary to Date");
        	System.out.println("========");
        	System.out.println("   3) Go Back");
        	System.out.println("====>>>>");
        	int choice = input.nextInt();
        	return choice;
        }
    
    private void totalSalaryInt(){
    	if(totalSalary<=0){
    		System.out.println("There is no salaries calculated");
    	}else{
    		System.out.println("The total calculated salary to date is: " + totalSalary);
    	}
    }

    private void clearSalary(){
    	totalSalary = 0;
    	System.out.println("Salarie total has been cleared.\n");
    	totalSalary();
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

	public void load() throws Exception
	{
		employees = HandleXML.read("employees.xml");
	}
	
	public void save() throws Exception
	{
		HandleXML.write(employees, "employees.xml");
	}
}
