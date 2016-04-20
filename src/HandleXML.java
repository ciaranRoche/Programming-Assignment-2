import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

/**
 * XML class for Assignment 2
 * This takes in information from the employee arraylist and saves it to a xml file
 * it gives back the information for the app, acts like a database
 */

/**
 * @author Ciaran Roche
 * @version 20/4/2016
 */

public class HandleXML {

	/*write method, takes in the information from the employee and writes it to the xml file*/
	
	public static void write(ArrayList<Employee> employees, String filename) throws Exception
	{
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream(filename)));
		encoder.writeObject(employees);
		encoder.close();
	}

	/*read method that takes the information from the xml file and puts back into the employee array list*/
	
	public static ArrayList<Employee> read(String filename) throws Exception 
	{
		XMLDecoder decoder =
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream(filename)));
		ArrayList<Employee> employees = (ArrayList<Employee>) decoder.readObject();
		decoder.close();
		return employees;
	}

}