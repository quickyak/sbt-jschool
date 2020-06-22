package spring.a34;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/a34/Config.xml");

//        MainBean mainBean = context.getBean("mainBean", MainBean.class);
//
//        System.out.println(mainBean.getDependencyBean());
//        System.out.println(mainBean.getDependencyPropertyBean());

        MainBean mainBean1 = context.getBean("mainBean", MainBean.class);
        MainBean mainBean2 = context.getBean("mainBean", MainBean.class);
        System.out.println("mainBean1 eq mainBean2 is " + mainBean1.equals(mainBean2));
    }

}
