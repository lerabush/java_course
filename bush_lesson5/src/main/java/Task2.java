import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class Task2 {
    public static void main(String[] args) {
        timeZoneExamples();
    }

    public static void timeZoneExamples() {
        ZoneId BLR = ZoneId.of("Asia/Calcutta");
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");

        //Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014
        // The flight is 5 hours 30 minutes
        //   What is the local time in Boston when the flight takes off?
        //   What is the local time at Boston Logan airport when the flight arrives?
        //   What is the local time in San Francisco when the flight arrives?
        System.out.println("Number 1");
        LocalDateTime startFromSanFr = LocalDate.of(2014, Month.JUNE, 13).atTime(22, 30);
        ZonedDateTime startFromSanFrZone = ZonedDateTime.of(startFromSanFr, SFO);
        LocalTime flightTime = LocalTime.of(5, 30);

        System.out.println("What is the local time in Boston when the flight takes off?  " + startFromSanFrZone.toOffsetDateTime()
                .atZoneSameInstant(BOS).toLocalTime());
        System.out.println("What is the local time at Boston Logan airport when the flight arrives? " + (startFromSanFrZone.plusHours(flightTime.getHour())
                .plusMinutes(flightTime.getMinute())).toOffsetDateTime()
                .atZoneSameInstant(BOS).toLocalTime());
        System.out.println("What is the local time in San Francisco when the flight arrives? " + startFromSanFrZone.
                plusHours(flightTime.getHour()).plusMinutes(flightTime.getMinute()).toLocalTime());
        // Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
        // The flight time is 22 hours
        //   Will the traveler make a meeting in Bangalore Monday at 9 AM local time?
        //   Can the traveler call her husband at a reasonable time when she arrives?
        System.out.println("Number 2");
        startFromSanFr = LocalDate.of(2014, Month.JUNE, 28).atTime(22, 30);
        startFromSanFrZone = ZonedDateTime.of(startFromSanFr, SFO);
        flightTime = LocalTime.of(22, 0);
        LocalDateTime meeting = LocalDate.of(startFromSanFr.getYear(), startFromSanFr.getMonth(),
                startFromSanFr.with(TemporalAdjusters.
                        next(DayOfWeek.MONDAY)).getDayOfMonth()).atTime(9, 0);
        ZonedDateTime zonedMeetingBLR = ZonedDateTime.of(meeting, BLR);
        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time? " + startFromSanFrZone.plusHours(flightTime.getHour())
                .toOffsetDateTime().atZoneSameInstant(BLR).isBefore(zonedMeetingBLR));
        System.out.println("Can the traveler call her husband at a reasonable time when she arrives? ");
        LocalTime travelerTime = startFromSanFrZone.plusHours(flightTime.getHour())
                .toOffsetDateTime().atZoneSameInstant(BLR).toLocalTime();
        LocalTime husbandTime = startFromSanFrZone.plusHours(flightTime.getHour())
                .toOffsetDateTime().toLocalTime();
        System.out.println("Traveler's local time:" + travelerTime);
        System.out.println("Husband's local time: " + husbandTime);
        if (travelerTime.getHour() > 8 && travelerTime.getHour() < 23
                && husbandTime.getHour() > 8 && husbandTime.getHour() < 23)
            System.out.println("Yes");
        else System.out.println("No:(");
        // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
        // Flight time is 5 hours 30 minutes.
        //   What day and time does the flight arrive in Boston?
        //   What happened?
        System.out.println("Number 3");
        startFromSanFr = LocalDate.of(2014, Month.NOVEMBER,1).atTime(22,30);
        flightTime = LocalTime.of(5,30);
        startFromSanFrZone = ZonedDateTime.of(startFromSanFr,SFO);
        System.out.println("What day and time does the flight arrive in Boston? "+startFromSanFrZone.plusHours(flightTime.getHour())
                .plusMinutes(flightTime.getMinute()).toOffsetDateTime().atZoneSameInstant(BOS).toLocalDateTime());


    }

}
