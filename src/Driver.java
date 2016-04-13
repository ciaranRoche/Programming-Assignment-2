
 
import java.util.ArrayList;
import java.util.Scanner;
 
public class Driver {
	
	Employee employee;
	private Scanner input;
	private static ArrayList<Employee> employees;
	
	public Driver(){
		input = new Scanner(System.in);	
	}
	
	public static void main(String args[])
	{
		Driver app = new Driver();
		app.run();
		employees = new ArrayList<Employee>();
	}
	
    private void run(){
		int option = menu();
		while(option != 0){
			switch (option){
			case 1:
			//	addEmployee();
				break;
			case 2:
			//	editEmployee();
				break;
			case 3:
			//	calculateSalary();
				break;
			case 4:
			//	listEmployee();
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
    	System.out.println("   2) Change an Employees Department");
    	System.out.println("   3) Calculate Employee Salaries");
    	System.out.println("   4) List Employee Details");
    	System.out.println("========");
    	System.out.println("   0) Exit");
    	System.out.println("====>>>>");
    	int choice = input.nextInt();
    	return choice;
    }


}
