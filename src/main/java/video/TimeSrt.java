package video;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeSrt {
    static final DateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss,SSS");
    static final DateFormat FORMATTER_SHORT = new SimpleDateFormat("HH:mm:ss");


    //00:00:00,000 --> 00:00:10,019
    private String complexValue;

    private Date startTime;
    private Date endTime;

    public TimeSrt(String complexValue) {
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
        Long delta = endTime.getTime() - startTime.getTime();
        return new Date(startTime.getTime()+(Long)delta/2);
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






    //разобрать строку 00:00:00,000 --> 00:00:10,019 в start и end

    public static void main(String[] args) {
        //        String testComplexValue = "00:00:00,000 --> 00:00:10,019";
        String strTestComplexValue = "02:51:34,629 --> 02:51:39,699";

        TimeSrt timeSrt = new TimeSrt(strTestComplexValue);
        System.out.println(timeSrt);
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

    private static Date getNullDate() {
        Date d = new Date(0L); //Этот конструктор принимает аргумент, равный количеству миллисекунд, прошедших с полуночи 1 января 1970 года. from https://coderlessons.com/tutorials/java-tekhnologii/uchit-java/java-data-i-vremia
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(d);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        d = c.getTime();
        return (d);
    }

    //Возвращает время в миллисекундах
    private  Long getDateMs(String stringDate) {
        return getDate(stringDate).getTime() - getNullDate().getTime();
    }
}

