package video.subtitle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import  java.util.Calendar;

public class SubtitleTime {
    static final DateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss,SSS");
    static final DateFormat FORMATTER_SHORT = new SimpleDateFormat("HH:mm:ss");


    //00:00:00,000 --> 00:00:10,019
    private String complexValue;

    private Date startTime;
    private Date endTime;

    public SubtitleTime(String complexValue) {
        this.complexValue = complexValue;
        populateDates();
    }

    public String getComplexValue() {
        return complexValue;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getMiddleTime() {
        long delta = endTime.getTime() - startTime.getTime();
        return new Date(startTime.getTime()+ delta /2);
    }

    @Override
    public String toString() {
        return "TimeSrt{" +
                FORMATTER.format(startTime)  +
                " to " + FORMATTER.format(endTime) +
                '}';
    }

    public String toStringStart() {
        return FORMATTER_SHORT.format(startTime);
    }

    public String toStringMiddle() {
        return FORMATTER_SHORT.format(getMiddleTime());
    }


    public static String timeToString(Date time) {
        return FORMATTER.format(time);
    }
    public static String timeToStringShort(Date time) {
        return FORMATTER_SHORT.format(time);
    }






    //разобрать строку 00:00:00,000 --> 00:00:10,019 в start и end

    public static void main(String[] args) {
        //        String testComplexValue = "00:00:00,000 --> 00:00:10,019";
        String strTestComplexValue = "02:51:34,629 --> 02:51:39,699";

        SubtitleTime subtitleTime = new SubtitleTime(strTestComplexValue);
        System.out.println(subtitleTime);
//        System.out.println(timeSrt.getStartTime());
//        System.out.println(timeSrt.getEndTime());

    }

    private void populateDates() {
        List<String> strings;
        strings = Arrays.asList(getComplexValue().split(" --> "));


        int idxPeriod = 0;
        for (String string:strings
             ) {
//            System.out.println(string);

            Date dt = getDate(string);
//            System.out.println(dt);

//            Long lng = getDateMs(string);
//            System.out.println(lng);

            switch(idxPeriod) {
                case 0:
                    startTime = dt;
                    break;

                case 1:
                    endTime = dt;
                    break;
            }
            idxPeriod++;
        }
    }

    @org.jetbrains.annotations.NotNull
    private Date getDate(String stringDate) {
        try {
            Date d = getNullDate(); //иницализируем дату, так как потом только время
            d =  FORMATTER.parse(stringDate);
            return (d);
        } catch (ParseException e) {
            e.printStackTrace();
            return getNullDate();
        }
    }

    public static Date getNullDate() {
        return (getNullDateWithTime(0,0,0,0));
    }

    public static Date getNullDateWithTime(int hours, int minutes, int seconds) {
        return (getNullDateWithTime(hours,minutes,seconds,0));
    }

    public static Date getNullDateWithTime(int hours, int minutes, int seconds, int millis) {
        Date d = new Date(0L); //Этот конструктор принимает аргумент, равный количеству миллисекунд, прошедших с полуночи 1 января 1970 года. from https://coderlessons.com/tutorials/java-tekhnologii/uchit-java/java-data-i-vremia
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(d);
        c.set(Calendar.HOUR_OF_DAY, hours);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.SECOND, seconds);
        c.set(Calendar.MILLISECOND, millis);
        d = c.getTime();
        return (d);
    }

    public static Date getNullDateWithTime(Date dateOnlyTime) {
        long longTime = dateOnlyTime.getTime();
        long restTime = longTime % (24*60*60*1000);
        return (new Date(restTime));
    }

    //Возвращает время в миллисекундах
    private  Long getDateMs(String stringDate) {
        return getDate(stringDate).getTime() - getNullDate().getTime();
    }
}

