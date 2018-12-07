import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//Display the current time (By converting datetime objects to strings) parse dates and time in 2 different time zones (java.time.zone).Display the current time (By converting datetime objects to strings) parse dates and time in 2 different time zones (java.time.zone).

public class DateandTime {

    LocalDateTime lDateTime;
    DateTimeFormatter dft;
    ZonedDateTime zDt;

    // Method to parse the datetime object to string
    // Arguments - ZoneId
    // Returns - NA

    void displayDateandTime(ZoneId zId) {

        lDateTime = LocalDateTime.now();
        dft = DateTimeFormatter.ISO_DATE;
        zDt = ZonedDateTime.of(lDateTime, zId);
        System.out.println("Date in " + zId.toString() + " is " + zDt.format(dft));

        dft = DateTimeFormatter.ISO_TIME;
        System.out.println("Time in " + zId.toString() + " is " + zDt.format(dft));
    }


    public static void main(String[] args) {

        ZoneId India, Aus;
        India = ZoneId.of("Asia/Kolkata");
        Aus = ZoneId.of("Australia/Sydney");

        System.out.println("Printing Date and Time ");
        new DateandTime().displayDateandTime(India);
        new DateandTime().displayDateandTime(Aus);

    }
}


