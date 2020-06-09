package hometask14.core.enumtest;

public class Program {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        System.out.println(day);

        printAll();

    }

    public static void printAll() {

        Day[] days = Day.values();
        for (Day d : days) { System.out.println(d); }
    }
}

enum Day{

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}