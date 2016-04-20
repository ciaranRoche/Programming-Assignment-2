/**
 * salesWorkerclass Class for Assignment 2
 * this salesworker class stores the information for sales workers
 * it calculates salary and bonus for employees in the sales worker class
 */

/**
 * @author Ciaran Roche
 * @version 20/4/2016
 */

public class SalesWorker extends Employee {

	private double bonus;

	/*saleWorker() constructor taking in a string firstname, second name and a double hourlyrate from the super class
	 * and it also takes in its own double bonus*/
	
	public SalesWorker(String firstName, String secondName, double hourlyRate, double bonus) {
		super(firstName, secondName, hourlyRate);
		this.bonus = bonus;
	}
	
	/*SalesWorker() empty constructor to fix bug with the xml*/
	
	public SalesWorker(){
		
	}
	
	/*calculateSalary() this calculates salary for any employee in the salesWorker class, 
	 * it takes in the method from the super and adds the bonus, but getting a percentage,
	 * figure from the super calc salary and adds it to the super calc salary*/
	
	public double calculateSalary(double hourlyRate) {
		return (((super.calculateSalary(hourlyRate)/100)*getBonus())+(super.calculateSalary(hourlyRate)));
	}
	
	/*****getter and setter for bonus******/

	public double getBonus() {
		if((bonus<0)&&(bonus>20)){
			return 0;
		}else{
			return bonus;
		}
	}

	public void setBonus(double bonus) {
		if((bonus>=0)&&(bonus<=20)){
			this.bonus = bonus;
		}
	}

	/*toString() a tostring method that overides the super too string*/
	
	public String toString(){
        return "Employee First Name: " + firstName 	
             + ", Surname: " + secondName
             + ", Hourly Rate " + hourlyRate
             + ", Bonus: " + bonus;      	
    }

}
