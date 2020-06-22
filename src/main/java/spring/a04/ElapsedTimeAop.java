package spring.a04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElapsedTimeAop {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Evaluator evaluator = context.getBean(Evaluator.class);

        double evaluate = evaluator.evaluate();

        System.out.println("evaluate: " + evaluate);
    }

}
