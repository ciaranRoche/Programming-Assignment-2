import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for the SalesWorker class
 */

/**
 * @author Ciaran Roche
 * @version 15/3/2016
 */

public class SalesWorkerTest {
	private SalesWorker sale1, sale2, invalidSale;

	/**
	 * Method to set up data for testing. 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sale1 = new SalesWorker("John", "Doe", 10, 12);
		sale2 = new SalesWorker("Bart", "Simpson", 8.50, 10);
		invalidSale = new SalesWorker("Peter", "Griffen", -1, 10);
	}

	/**
	 * Test method for AdminWorker constructor
	 */
	@Test
	public void testConstructor() {
		//test on valid data
		assertEquals("John", sale1.getFirstName());
		assertEquals("Doe", sale1.getSecondName());
		assertEquals(10, sale1.getHourlyRate(), 0.01);
		//test on invalid data
		assertEquals(0, invalidSale.getHourlyRate(), 0.01);

	}
	
	/**
	 * Test method for calculateSalary(), testing for employees with and without overtime. 
	 */
	@Test	
	public void testCaclulateSalary(){
		assertEquals(350.62, sale2.calculateSalary(37.5), 0.01 );
		assertEquals(397.37, sale2.calculateSalary(40), 0.01 );
		
		assertEquals(336, sale1.calculateSalary(30), 0.01 );
		assertEquals(342.35, sale1.calculateSalary(30.5678), 0.01 );
	}
	
	/**
	 * Test method for getBonus and setBonus. (Validation on this field)
	 */
	@Test
	public void testGetSetBonus() {
		assertEquals(12, sale1.getBonus(), 0.01);
        sale1.setBonus(-1);
		assertEquals(12, sale1.getBonus(), 0.01);
        sale1.setBonus(0);
        assertEquals(0, sale1.getBonus(), 0.01);
        sale1.setBonus(12);
        assertEquals(12, sale1.getBonus(), 0.01);
        sale1.setBonus(21);
        assertEquals(12, sale1.getBonus(), 0.01);
	}
	
	/**
	 * Test method for getters and setters. 
	 */
	@Test	
	public void testSettersGetters(){	
		assertEquals("John", sale1.getFirstName());
		sale1.setFirstName("Tommy Gun");
		assertEquals("Tommy Gun", sale1.getFirstName());
		
		assertEquals("Doe", sale1.getSecondName());
		sale1.setSecondName("Homer Simpson");
		assertEquals("Homer Simpson", sale1.getSecondName());

		sale1.setHourlyRate(40);
		assertEquals(40, sale1.getHourlyRate(), 0.01);
		
		//ensure no change when invalid data used
		sale1.setHourlyRate(-40);
		assertEquals(40, sale1.getHourlyRate(), 0.01);	
	}
	
}