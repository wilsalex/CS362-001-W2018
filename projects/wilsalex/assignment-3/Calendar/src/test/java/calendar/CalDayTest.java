package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
    @Test
    public void testCalDay() {
        CalDay dayTest = new CalDay();
        assertFalse(dayTest.isValid());
    }
    @Test
    public void testAddAppt(){
        Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
        Appt newAppt2 = new Appt(12,0,20,2,2017, "Coffee", "Drink coffee.");
        CalDay dayTest = new CalDay(new GregorianCalendar(2017,1,29));
        dayTest.addAppt(newAppt);
        assertEquals(1, dayTest.getSizeAppts());
        assertEquals(newAppt, dayTest.getAppts().get(0));

        //test if statement
        dayTest.addAppt(newAppt2);
        assertEquals(2, dayTest.getSizeAppts());
        assertEquals(newAppt2, dayTest.getAppts().get(0));

        newAppt = new Appt(12,0,20,2,2017, "Dentist", "Go to dentist.");
        newAppt2 = new Appt(12,0,20,2,2017, "Coffee", "Drink coffee.");
        dayTest = new CalDay(new GregorianCalendar(2017,1,29));
        dayTest.addAppt(newAppt);
        assertEquals(1, dayTest.getSizeAppts());
        assertEquals(newAppt, dayTest.getAppts().get(0));
        dayTest.addAppt(newAppt2);
        assertEquals(2, dayTest.getSizeAppts());
        assertEquals(newAppt2, dayTest.getAppts().get(1));
    }

    @Test
    public void testSetDay(){
        CalDay dayTest = new CalDay(new GregorianCalendar(2017,2,20));
        assertEquals(20, dayTest.getDay());
    }

    @Test
    public void testSetMonth(){
        CalDay dayTest = new CalDay(new GregorianCalendar(2017,2,20));
        assertEquals(2, dayTest.getMonth());
    }

    @Test
    public void testSetYear(){
        CalDay dayTest = new CalDay(new GregorianCalendar(2017,1,29));
        assertEquals(2017, dayTest.getYear());
    }

    @Test
    public void testToString(){
        //testing if statement
        CalDay dayTest = new CalDay(new GregorianCalendar(2017,3,20));
        //assertEquals("03/20/2017", dayTest.toString());

        //testing while loop
        Appt newAppt = new Appt(14,0,20,3,2017, "Dentist", "Go to dentist.");
        Appt newAppt2 = new Appt(12,0,20,3,2017, "Coffee", "Drink coffee.");
        dayTest.addAppt(newAppt);
        dayTest.addAppt(newAppt2);
        String expected = "\t --- 3/20/2017 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/20/2017 at 12:0pm ,Coffee, Drink coffee.\n" +
                " \t3/20/2017 at 2:0pm ,Dentist, Go to dentist.\n \n";
        assertEquals(expected, dayTest.toString());

        //tests if statement when isValid is false
        dayTest = new CalDay();
        assertEquals("", dayTest.toString());
    }

    @Test
    public void testIterator(){
        //testing else
        CalDay dayTest = new CalDay();
        assertNull(dayTest.iterator());

        //testing if statement
        Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
        dayTest = new CalDay(new GregorianCalendar(2017,1,29));
        dayTest.addAppt(newAppt);
        assertEquals(newAppt, dayTest.iterator().next());
    }

//add more unit tests as you needed	
}
