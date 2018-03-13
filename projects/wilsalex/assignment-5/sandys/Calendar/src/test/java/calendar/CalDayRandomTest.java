package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    /**
     * Generate Random Tests that tests CalDay Class.
     */

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

    @Test
    public void randomTestAddAppt() {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


        System.out.println("Start testing...");

        try {
            CalDay dayTest = new CalDay(new GregorianCalendar(2017,2,25));
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed = System.currentTimeMillis(); //10
                Random random = new Random(randomseed);

                int startHour = ValuesGenerator.RandInt(random);
                int startMinute = ValuesGenerator.RandInt(random);
                int startDay = ValuesGenerator.RandInt(random);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear = ValuesGenerator.RandInt(random);
                String title = "Birthday Party";
                String description = "This is my birthday party.";

                Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);

                dayTest.addAppt(appt);

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

            }
        } catch (NullPointerException e) {

        }

        System.out.println("Done testing...");
    }
}