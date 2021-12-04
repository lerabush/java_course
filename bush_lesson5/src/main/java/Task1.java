import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class Task1 {

    public static void main(String[] args) {
        birthdays();
        departureAndArrival();
        schoolTime();
        Boolean isTuesday = LocalDate.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
        LocalTime timeMeeting = LocalTime.of(13, 30);
        System.out.println(timeMeeting);
        if (isTuesday && LocalTime.now().isBefore(timeMeeting))
            System.out.println("Meeting is today!It's left: " + Duration.between(LocalTime.now(), timeMeeting).toHours());
        else if (!isTuesday) System.out.println("Not today!");
        else System.out.println("Meeting has already ended");

    }

    public static void birthdays() {
        // Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
        //   How old when he died?
        //   How many days did he live?
        System.out.println("Number 1");
        LocalDate bDay = LocalDate.of(1809, 2, 12);
        LocalDate dDay = LocalDate.of(1855, 4, 15);
        System.out.println(Period.between(bDay, dDay).getYears());
        System.out.println(DAYS.between(bDay, dDay));
        // Bennedict Cumberbatch, July 19, 1976
        //   Born in a leap year?
        //   How many days in the year he was born?
        //   How many decades old is he?
        //   What was the day of the week on his 21st birthday?
        System.out.println("Number 2");
        bDay = LocalDate.of(1976, 7, 19);
        System.out.println("is leap year? " + bDay.isLeapYear());
        System.out.println(bDay.isLeapYear() ? 366 : 365 + " days");
        System.out.println(Period.between(bDay, LocalDate.now()).getYears() / 10);
        LocalDate bDay21 = LocalDate.of(1997, 7, 19);
        System.out.println(bDay21.getDayOfWeek());
    }

    public static void schoolTime() {
        // School semester starts the second Tuesday of September of this year.
        //   Hint: Look at the TemporalAdjusters class
        //   What is the date?
        //   School summer vacation starts June 25th
        //   Assuming:
        //     *  Two weeks off in December
        //     *  Two other vacation weeks
        //     *  School is taught Monday - Friday
        //   How many days of school are there?
        //   Hint: keep track of the short weeks also
        System.out.println("Number 5");
        LocalDateTime schoolStarts = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 1).atStartOfDay()
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY));

        System.out.println(schoolStarts.plusDays(7));
        LocalDateTime finishSemester = LocalDate.of(LocalDate.now().getYear() + 1, Month.JUNE, 25).atStartOfDay();
        long daysInSchool = Duration.between(schoolStarts.atOffset(ZoneOffset.UTC), finishSemester.atOffset(ZoneOffset.UTC)).toDays();
        System.out.println((daysInSchool / 7 - 4) * 5);
    }

    public static void departureAndArrival() {
        // Train departs Boston at 1:45PM and arrives New York 7:25PM
        //   How many minutes long is the train ride?
        //   If the train was delayed 1 hour 19 minutes, what is the actual arrival time?
        System.out.println("Number 3");
        LocalTime timeDepart = LocalTime.of(13, 45);
        LocalTime timeArrival = LocalTime.of(19, 25);
        System.out.println(Duration.between(timeDepart, timeArrival).toMinutes());
        System.out.println(timeArrival.plusHours(1).plusMinutes(19));
        // Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
        //   When does it arrive in Miami?
        //   When does it arrive if the flight is delays 4 hours 27 minutes?
        System.out.println("Number 4");
        LocalDateTime timeDate = LocalDate.of(LocalDate.now().getYear(), 3, 24).atTime(21, 15);
        LocalDateTime arrivalDate = timeDate.plusHours(4).plusMinutes(15);
        System.out.println(arrivalDate);
        System.out.println(arrivalDate.plusHours(4).plusMinutes(27));
    }
}
