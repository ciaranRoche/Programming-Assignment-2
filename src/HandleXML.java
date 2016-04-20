import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;

public class HandleXML {

	public static void write(ArrayList<Employee> employees, String filename) throws Exception
	{
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream(filename)));
		encoder.writeObject(employees);
		encoder.close();
	}

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