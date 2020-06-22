package spring.a33;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/a33/Config.xml");

        Tiger asiaTiger = context.getBean("asiaTiger", Tiger.class);

        asiaTiger.printAbout();
    }

}
