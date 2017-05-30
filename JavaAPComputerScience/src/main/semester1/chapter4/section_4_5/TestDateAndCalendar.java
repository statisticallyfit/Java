package semester1.chapter4.section_4_5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user1928 on 11/22/14.
 */
public class TestDateAndCalendar {

    public static void main(String[] args) {

        //DateFormat objects can have just year/month/day or that as well as HH:mm:ss
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        //get current date time with Date()
        Date currentDateUnformatted = new Date();

        try {
            /**
             * currentDayStr is in form yyyy/MM/dd since dateFormat object is called
             */
            String currentDayStr = dateFormat.format(currentDateUnformatted);

            /*
             * Make object dateTimeFormat accept argument "00:00:00" as the HH:mm:ss part since dateTimeFormat takes hours, min , ss too
             * Because currentDayMidnight must be in same format as date object
             * So that we can find diffMillis = difference in milliseconds
             */
            Date currentDayMidnight = dateTimeFormat.parse(currentDayStr + " 00:00:00");

            // subtract and convert to minutes
            long diffMillis = currentDateUnformatted.getTime() - currentDayMidnight.getTime();
            long diffMins = diffMillis/1000/60;
            System.out.println("Total number of minutes since midnight: " + diffMins);
        } catch (ParseException e) { //to catch error if dateTimeFormat cannot parse the currentDayStr with "00:00:00"
            e.printStackTrace();
        }
    }
}
