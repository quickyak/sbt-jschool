package spring.a44;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.a44.house.HenHouse;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        HenHouse henHouse = context.getBean(HenHouse.class);
        henHouse.printHens();
        System.out.println(henHouse.getProperty());;
    }

}
