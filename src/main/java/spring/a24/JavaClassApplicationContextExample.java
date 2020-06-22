package spring.a24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.a20.ConsoleMessageRenderer;

public class JavaClassApplicationContextExample {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ConsoleMessageRenderer consoleRenderer = context.getBean(
                "myRenderer",
                ConsoleMessageRenderer.class);

        consoleRenderer.renderMessage();
    }

}
