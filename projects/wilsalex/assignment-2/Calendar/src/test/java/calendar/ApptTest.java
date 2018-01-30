package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;


import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void testRecur(){
		 Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
		 int myArray[] = {1,2,3};
		 newAppt.setRecurrence(myArray,1,1,2);
		 assertEquals(1,newAppt.getRecurBy());
		 assertEquals(1,newAppt.getRecurIncrement());
		 assertEquals(myArray, newAppt.getRecurDays());

	 }

	 @Test
	public void testSetters(){
		 Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
		 newAppt.setStartHour(7);
		 assertEquals(7,newAppt.getStartHour());
		 newAppt.setStartMinute(7);
		 assertEquals(7,newAppt.getStartMinute());
		 newAppt.setStartDay(7);
		 assertEquals(7,newAppt.getStartDay());
		 newAppt.setStartMonth(7);
		 assertEquals(7,newAppt.getStartMonth());
		 newAppt.setStartYear(2007);
		 assertEquals(2007,newAppt.getStartYear());
		newAppt.setTitle(null);
		assertEquals("",newAppt.getTitle());
		 newAppt.setDescription(null);
		 assertEquals("",newAppt.getDescription());
	 }

	 @Test
	public void testValid(){
		 Appt newAppt = new Appt(24,0,20,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());
		 newAppt = new Appt(14,101,20,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());
		 newAppt = new Appt(14,0,60,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());
		 newAppt = new Appt(14,0,20,0,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());
		 newAppt = new Appt(-1,0,20,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());
		 newAppt = new Appt(14,-1,20,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());
		 newAppt = new Appt(14,0,0,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.getValid());

	 }
//add more unit tests as you needed
	
}
