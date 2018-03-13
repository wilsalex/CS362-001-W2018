package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
    @Test
    public void testTimeTable(){

    }

    @Test
    public void testGetApptRange(){
        TimeTable table = new TimeTable();
        LinkedList<Appt> apptList = new LinkedList<Appt>();
        Appt newAppt = new Appt(14,0,20,7,2017, "Dentist", "Go to dentist.");
        apptList.add(newAppt);
        Appt newAppt2 = new Appt(12,0,21,7,2017, "Coffee", "Drink coffee.");
        apptList.add(newAppt2);


        //testing if statement exception
        boolean occurred = false;
        try{
            table.getApptRange(apptList, new GregorianCalendar(2017,7,21), new GregorianCalendar(2017,7,20));
        }
        catch(DateOutOfRangeException e){
            occurred = true;
        }
        assertTrue(occurred);


        apptList = new LinkedList<Appt>();
        newAppt = new Appt(14,0,20,7,2017, "Dentist", "Go to dentist.");
        newAppt2 = new Appt(12,0,21,7,2017, "Coffee", "Drink coffee.");
        int myArray[] = {1,2,3};
        newAppt.setRecurrence(myArray,1,1,2);
        apptList.add(newAppt);
        apptList.add(newAppt2);
        try{
            LinkedList<CalDay> result = table.getApptRange(apptList, new GregorianCalendar(2017, 7, 18), new GregorianCalendar(2017, 7, 22));
            assertEquals(18, result.get(0).getDay());
        }
        catch(DateOutOfRangeException e) {
        }



    }

    @Test
    public void testGetNextApptOccurance(){
        TimeTable table = new TimeTable();
        LinkedList<Appt> apptList = new LinkedList<Appt>();
        Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
        apptList.add(newAppt);
        Appt newAppt2 = new Appt(12,0,20,2,2017, "Coffee", "Drink coffee.");
        apptList.add(newAppt2);
        Appt newAppt3 = new Appt(11,0,20,2,2017, "Brunch", "Drink coffee.");
        apptList.add(newAppt3);
        int myArray[] = {1,2,3};
        newAppt.setRecurrence(myArray,1,1,2);
        /*try {
            table.getApptRange(apptList, new GregorianCalendar(2017, 2, 19), new GregorianCalendar(2017, 2, 21));
        }
        catch(DateOutOfRangeException e){
        }*/

    }

    @Test
    public void testGetApptOccurences(){

    }

    @Test
    public void testPermute(){

    }

    @Test
    public void testDeleteAppt(){
        TimeTable table = new TimeTable();
        LinkedList<Appt> apptList = new LinkedList<Appt>();
        assertEquals(0, apptList.size());
        table.deleteAppt(apptList, null);
        assertEquals(0, apptList.size());

        Appt newAppt = new Appt(14,0,20,2,2017, "Dentist", "Go to dentist.");
        apptList.add(newAppt);
        Appt newAppt2 = new Appt(12,0,20,2,2017, "Coffee", "Drink coffee.");
        apptList.add(newAppt2);
        Appt newAppt3 = new Appt(11,0,20,2,2017, "Brunch", "Drink coffee.");
        apptList.add(newAppt3);
        assertEquals(3,apptList.size());

        table.deleteAppt(apptList, newAppt2);
        assertEquals(2,apptList.size());

        Appt newAppt4 = new Appt(-11,0,20,2,2017, "Brunch", "Drink coffee.");
        apptList.add(newAppt4);
        assertEquals(3,apptList.size());
        table.deleteAppt(apptList, newAppt4);
        assertEquals(3,apptList.size());
    }
//add more unit tests as you needed
}
