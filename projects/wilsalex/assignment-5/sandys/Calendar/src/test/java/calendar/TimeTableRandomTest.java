package calendar;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */


	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

	@Test
	  public void randomtestDeleteAppt()  throws Throwable  {
		 //loop creates 0-3 appt
		 	//create appt
		 	//randomly choose appt to delete

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				LinkedList<Appt> appts;

				int num = ValuesGenerator.getRandomIntBetween(random,0,3);
				if(num == 0){
				    appts = null;
                }
                else {
                    appts = new LinkedList<Appt>();
                    for (int i = 0; i < num; i++) {
                        int startHour = ValuesGenerator.RandInt(random);
                        int startMinute = ValuesGenerator.RandInt(random);
                        int startDay = ValuesGenerator.RandInt(random);
                        int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                        int startYear = ValuesGenerator.RandInt(random);
                        String title = "Birthday Party";
                        String description = "This is my birthday party.";

                        Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
                        appts.add(appt);
                    }
                }
                int remove = ValuesGenerator.getRandomIntBetween(random,0,num);
                Appt apptRemove;
                if(remove == num){
                    apptRemove = null;
                }
                else{
                    apptRemove = appts.get(remove);
                }
                TimeTable table = new TimeTable();
                table.deleteAppt(appts,apptRemove);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
			}
		} catch (NullPointerException e) {

		}
		System.out.println("Done testing...");
	}

    @Test
    public void randomtestGetApptRange()  throws Throwable {
	    //loop appt
            //randomly create appt
	    //loop appt range
	        //randomly select two days
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start testing...");

        long randomseed = System.currentTimeMillis(); //10
        Random random = new Random(randomseed);

        int year = ValuesGenerator.RandInt(random);
        int month = ValuesGenerator.getRandomIntBetween(random,1,11);

        try {
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                LinkedList<Appt> appts;
                int num = ValuesGenerator.getRandomIntBetween(random, 0, 3);
                if (num == 0) {
                    appts = null;
                } else {
                    appts = new LinkedList<Appt>();
                    for (int i = 0; i < num; i++) {
                        int startHour = ValuesGenerator.RandInt(random);
                        int startMinute = ValuesGenerator.RandInt(random);
                        int startDay = ValuesGenerator.RandInt(random);
                        String title = "Birthday Party";
                        String description = "This is my birthday party.";

                        Appt appt = new Appt(startHour, startMinute, startDay, month, year, title, description);
                        appts.add(appt);
                    }
                }
                TimeTable table = new TimeTable();
                int day1 = ValuesGenerator.RandInt(random);
                int day2 = ValuesGenerator.RandInt(random);
                try {
                    table.getApptRange(appts, new GregorianCalendar(year, month, day1), new GregorianCalendar(year, month, day2));
                }
                catch(DateOutOfRangeException e){

                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
            }
        } catch (NullPointerException e) {

        }
        System.out.println("Done testing...");
    }
}
