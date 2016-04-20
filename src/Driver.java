/**
 * Driver Class for Assignment 2
 * This is a menu driven class, where the user can add employees, list employees, 
 * calculate salaries, store and load their employees and add employees to departments,
 * All the information is stored in strings and doubles in an Arraylist Employee
 */

/**
 * @author Ciaran Roche
 * @version 20/4/2016
 */
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class Driver {
	
	Employee employee;
	
	
	private Scanner input;
	private static ArrayList<Employee> employees;
	
	public double hoursWorked;
	public double totalSalary = 0;
	
	/* Constructor for driver and scanner*/
	
	public Driver(){
		input = new Scanner(System.in);

	}
	
	
	public static void main(String args[])
	{
		Driver app = new Driver();
		employees = new ArrayList<Employee>();
		app.run();
		
	}
	
	/*Run() this method displays the menu and processes the users choice
	 * option 1, brings another menu adding employees
	 * option 2, lists employees in the system
	 * option 3, adds employees to a specific manager/department
	 * option 4, calculates a specific employees wages
	 * option 5, gives totalSalary menu, allowing to clear total salary plus view salary
	 * option 6, allows the user to edit employees
	 * option 7, allows the user to delete employees
	 * option 8, loads employees from an xml file
	 * option 9, saves employees to an xml file
	 * option 0, exits the system
	 * */
	
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
			case 10:
				stats();
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
    
    /*
     * menu() this prints the main menu for the application
     * */
    
    private int menu(){
    	System.out.println("Employee index/payroll");
    	System.out.println("Please select the number of the option you want below");
    	System.out.println("   1) Add a new Employee");
    	System.out.println("   2) List Employees");
    	System.out.println("   3) Add an Employee to a Department");
    	System.out.println("   4) Calculate Employee Salaries");
    	System.out.println("   5) Total Salary Menu");
    	System.out.println("   6) Edit Employees Details" );
    	System.out.println("   7) Remove Employee from system");
    	System.out.println("========");
    	System.out.println("   8) Load Employees");
    	System.out.println("   9) Save Employees");
    	System.out.println("========");
    	System.out.println("  10) Stats");
    	System.out.println("========");
    	System.out.println("   0) Exit");
    	System.out.println("====>>>>");
    	int choice = input.nextInt();
    	return choice;
    }

    /*
     * addEmployeeChoices() this displays the menu for adding an employee and processes the users choice
     * option 1, adds a manager
     * option 2, adds a sales worker
     * option 3, adds a temp worker
     * */
    
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
    
    /*
     * addEmployeeMenu prints the choices for adding an employee
     * */
    
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
  
    /*
     * addEmployeeDept() this method lists all employees with their index number
     * taking the users input and saving it, then lists all employees allowing the user
     * to choose a manager from the list
     * it then adds the first index number to the managers index number in a manager arrayList
     * */
    
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
    			System.out.println("Invalid options picked \nPlease Choose an employee first, and a manager second:");
    			System.out.println("Please start over\n=======");
    			addEmployeeDept();
    		}
		
    	}
    	else{
    		//System.out.println("There is no Employee for this index number");
			//System.out.println("Please choose another index number:");
			//addEmployeeDept();
    	}
    }
    
    /*
     * editEmployee() This gives a list of employees and takes the users input from the index numbers
     * creates an opject of this index number and cross checks it to see what class it is equal too
     * depending on what class it is equal too, it takes in information needed and sets new information over
     * existing information in the choosen index number
     * */
    
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
					System.out.println("Please enter Managers Bonus to be added to weekly wage:");
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
			    	System.out.println("Please enter Employee Bonus Percentage of weekly wage to be added between 0 and 20 percent:");
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
	
	/*fireEmployee() this method prints a list of employees
	 * takes in users choosen int as an index number. and deletes the employee
	 * in choosen index number
	 * */
	
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
	
	/*calcWages() This prints list of employees, takes in index number of employee in which the user wants 
	 * to calculate wages for. takes in double for hours worked and then calls on the employee.calculateSalary method
	 * returns by printing out the total for the calculated salary*/

    private void calcWages(){
    	System.out.println(listEmployees());
    	
    	if (getEmployees().size() != 0){
    		System.out.print("Index of employees ==>");
    		int index = input.nextInt();
    		
    		if (index < getEmployees().size()){	
				
    			System.out.print("Enter hours worked this week ");
				hoursWorked = input.nextDouble();
				employee = getEmployees().get(index);
				System.out.println(toTwoDecimalPlaces(employee.calculateSalary(hoursWorked)));
				
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
        
    /*totalSalary() This method displays and processes the total salary method
     * option 1 prints total salary calculated to date
     * option 2 clears the salary
     * option 3 returns to the main menu*/
    
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
    
    /*salaryMenu() this prints the options for the totalsalary method
     * */
    	   
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
    
    /*totalSalaryInt() this checks the total salary and if the double is less then or equal to zero
     * it prints no salary calculated other wise it prints total salary calculated to date*/
    
    private void totalSalaryInt(){
    	if(totalSalary<=0){
    		System.out.println("There is no salaries calculated");
    	}else{
    		System.out.println("The total calculated salary to date is: " + toTwoDecimalPlaces(totalSalary));
    	}
    }

    /*clearSalary()This resets the total salary back to zero*/
    
    private void clearSalary(){
    	totalSalary = 0;
    	System.out.println("Salarie total has been cleared.\n");
    	totalSalary();
    }
    
    /*addTempWorker() this takes in string firstname, string lastname and a double hourlyrate
     * and adds them to employees arrraylist as a new tempworker*/
    
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

	/*addSalesWorker() this takes in a string firstname, a string lastname a double hourlyrate and double bonus
	 * and adds them to employees arraylist as a new salesWorker*/
	
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
	
	/*addManager() this takes in a string firstname, a string lastname, a double hourlyrate and double bonus
	 * and adds them to the employees arraylist as a new manager*/

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
	
	/*listEmployees() this checks the size of the employee array
	 * if there is more then 1 it creates a string called listEmployees
	 * it then running through a for loop it lists all employees in the arraylist*/
	
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
	
	/*Simple getter for the arraylist Employee*/
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/*load() basic load method for an xml file*/
	
	public void load() throws Exception
	{
		employees = HandleXML.read("employees.xml");
	}
	
	/*save() basic save method for an xml file*/
	
	public void save() throws Exception
	{
		HandleXML.write(employees, "employees.xml");
	}
	
	/*
	 * toTwoDecimalPlaces() this method reduces a double with mult decimal places to just two decimal places
	 * */
	
	private double toTwoDecimalPlaces(double num)
    {
        return (int) (num *100 ) /100.0; 
    }
	
	/*stats() method for controlling and processing the choice made for the stats menu
	 * 
	 * */
	
	private void stats(){
    	int option = statsMenu();
		while(option != 0){
			switch (option){
			case 1:
			    System.out.println("The average hourly rate paid to all employees is: " +averageEmployeeWage());
				break;
			case 2:
				System.out.println("The lowest hourly rate paid to any employee is: "  + lowestWage());
				break;
			case 3:
				System.out.println(listEmployeesUnderMinWage());	
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
            
			option = statsMenu();
		}		
	}
	
	/*statsMenu() Print out of a list of options for the stats menu
	 * option 1 gives list of average employees wage
	 * option 2 gives a print out of the lowest paid worker
	 * option 3 gives a list of any employees on a lower wage than min wage*/
	
	private int statsMenu(){
		System.out.println("Salary Stats Menu");
    	System.out.println("Please select the number of the option you want below");
    	System.out.println("   1) The average wage of all Employees");
    	System.out.println("   2) The lowest paid hourly rate of all Employees");
    	System.out.println("   3) List of any Employees on lower than minimum wage of 9.15");
    	System.out.println("========");
    	System.out.println("   4) Go Back");
    	System.out.println("====>>>>");
    	int choice = input.nextInt();
    	return choice;
	}
	
	/*
	 * averageEmployeeWage that creates a double, 
	 * for every employee in employees it adds their hourly rates together
	 * and divides by employee size to give an average rate
	 * */
	
	private double averageEmployeeWage(){
        double total = 0;
        for (Employee employee : employees)
        { 
            total = total + employee.hourlyRate;
        }
        
        return toTwoDecimalPlaces(total / employees.size());
    }
	
	/*
	 * lowestWage()method for given the lowest Wage
	 * for every employee in employees if takes the hourly rate and looks for the lowestRate
	 */
	
    private String lowestWage(){
    	if (getEmployees().size() > 0)
        {
            Employee lowestWage = employees.get(0);
            for (Employee employee : employees)
            { 
                if (employee.getHourlyRate() < lowestWage.getHourlyRate() )  
                    lowestWage = employee;
            }
            return lowestWage.getFirstName();
        }
        else 
            return "No Employees";
    }
    
    /*listEmployeesUnderMinWage()
     * this method gives a list of employees under the min wage
     */
    
    public String listEmployeesUnderMinWage(){
        String str = "";
        double minWage = 9.15;
        for (Employee employee : employees)
        {
           if (employee.getHourlyRate() < minWage)
                str += "Employee(s) on an hourly rate below "+ minWage+" are: " + employee.getFirstName() + " " + employee.getSecondName() + " " + toTwoDecimalPlaces(employee.getHourlyRate()) + "\n";   
        } 

        if (str.equals(""))
        {
            return "No Employees are on an hourly rate more than " + minWage;
        }
        else 
            return str;
    }     
	
	
	
	
	
	
}
