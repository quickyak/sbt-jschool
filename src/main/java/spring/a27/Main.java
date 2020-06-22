package spring.a27;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/a27/config.xml");

        Car myCar = context.getBean("bestCar", Car.class);
//
        myCar.go();
//
//        Car mySecondCar = context.getBean("mySecondCar", Car.class);
////
//        mySecondCar.go();
//
//        Car myThirdCar = context.getBean("myThirdCar", Car.class);
//
//        myThirdCar.go();
//
        ConfigPrinter configPrinter = context.getBean("configPrinter", ConfigPrinter.class);
        configPrinter.printInfo();
//
//        // Lookup method
        Passenger passenger1 = myCar.getPassengerOnBoard();
        Passenger passenger2 = myCar.getPassengerOnBoard();
        System.out.println("passenger1 eq passenger2 is " + (passenger1.equals(passenger2)));



        Car car1 = context.getBean("car", Car.class);
//        Car car2 = context.getBean("car", Car.class);
//        Car car3 = context.getBean("car", Car.class);
//        Car car4 = context.getBean("car", Car.class);
        Passenger passengerOnBoard1 = car1.getPassengerOnBoard();
//        Passenger passengerOnBoard2 = car2.getPassengerOnBoard();
        System.out.println("*****");
    }

}
