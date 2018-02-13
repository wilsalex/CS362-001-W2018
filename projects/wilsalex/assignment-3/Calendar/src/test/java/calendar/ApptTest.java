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

	//Set recurrence test
         assertEquals(0,appt.getRecurDays().length);
	 }

	 @Test
	  public void testRecur(){
		 Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
		 assertFalse(newAppt.isRecurring());

		 int myArray[] = {1,2,3};
		 newAppt.setRecurrence(myArray,1,1,2);
		 assertEquals(1,newAppt.getRecurBy());
		 assertEquals(1,newAppt.getRecurIncrement());
         assertEquals(2,newAppt.getRecurNumber());
		 assertEquals(myArray, newAppt.getRecurDays());

		 assertTrue(newAppt.isRecurring());

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
     public void testSettersValid(){
         Appt newAppt = new Appt(-1,0,20,2,2017, "Dentist", "Go to dentist.");
         assertFalse(newAppt.getValid());
         newAppt.setStartHour(7);
         assertTrue(newAppt.getValid());
         newAppt = new Appt(14,-1,20,2,2017, "Dentist", "Go to dentist.");
         assertFalse(newAppt.getValid());
         newAppt.setStartMinute(7);
         assertTrue(newAppt.getValid());
         newAppt = new Appt(14,0,-20,2,2017, "Dentist", "Go to dentist.");
         assertFalse(newAppt.getValid());
         newAppt.setStartDay(7);
         assertTrue(newAppt.getValid());
/*         newAppt = new Appt(14,0,20,-2,2017, "Dentist", "Go to dentist.");
         assertFalse(newAppt.getValid());
         newAppt.setStartMonth(7);
         assertTrue(newAppt.getValid());*/
     }

	 @Test
	public void testValid(){
	 	Appt newAppt = new Appt (22,0,20,2,2017, "Dentist", "Go to dentist.");
	 	for(int i = 1; i < 24; i++) {
            newAppt = new Appt(i,0,20,2,2017, "Dentist", "Go to dentist.");
            assertTrue(newAppt.getValid());
        }
        newAppt = new Appt(0,0,20,2,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());
        newAppt = new Appt(24,0,20,2,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());
	 	for(int i = 0; i < 101; i++) {
	 	    newAppt = new Appt(22,i,20,2,2017, "Dentist", "Go to dentist.");
	 	    assertTrue(newAppt.getValid());
	 	}
	 	newAppt = new Appt(14,-1,20,2,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());
	 	newAppt = new Appt(14,101,20,2,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());
	 	for(int i = 1; i < CalendarUtil.NumDaysInMonth(2017,3); i++) {
	 	    newAppt = new Appt(22,0,i,3,2017, "Dentist", "Go to dentist.");
	 	    assertTrue(newAppt.getValid());
	 	}
	 	newAppt = new Appt(14,0,0,2,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());
	 	newAppt = new Appt(22,0,(CalendarUtil.NumDaysInMonth(2017,3)+1),2,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());
	 	for(int i = 1; i < 11; i++) {
	 	    newAppt = new Appt(22,0,20,i,2017, "Dentist", "Go to dentist.");
	 	    assertTrue(newAppt.getValid());
	 	}
	 	newAppt = new Appt(22,0,20,0,2017, "Dentist", "Go to dentist.");
	 	assertFalse(newAppt.getValid());

	 }

	 @Test
    public void testToString(){
	     Appt newAppt = new Appt(11, 7, 7, 3, 2017, "Dentist", "Go to dentist.");
	     assertTrue(newAppt.getValid());
	     assertEquals("\t3/7/2017 at 11:7am ,Dentist, Go to dentist.\n",newAppt.toString());
         newAppt = new Appt(12, 7, 7, 3, 2017, "Dentist", "Go to dentist.");
         assertTrue(newAppt.getValid());
         assertEquals("\t3/7/2017 at 12:7pm ,Dentist, Go to dentist.\n",newAppt.toString());
         newAppt = new Appt(-1, 7, 7, 3, 2017, "Dentist", "Go to dentist.");
         assertEquals(null,newAppt.toString());
     }

     @Test
    public void testCompareTo(){
         Appt newAppt1 = new Appt(11, 7, 7, 3, 2017, "Dentist", "Go to dentist.");
         Appt newAppt2 = new Appt(12, 7, 7, 3, 2017, "Dentist", "Go to dentist.");
         assertEquals(-1,newAppt1.compareTo(newAppt2));
         newAppt1 = new Appt(12, 8, 8, 4, 2018, "Dentist", "Go to dentist.");
         newAppt2 = new Appt(11, 7, 7, 3, 2017, "Dentist", "Go to dentist.");
         assertEquals(5,newAppt1.compareTo(newAppt2));

     }



//add more unit tests as you needed
	
}
