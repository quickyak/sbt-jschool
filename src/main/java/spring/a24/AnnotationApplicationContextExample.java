package spring.a24;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.a20.ConsoleMessageRenderer1;

@Lazy
@Configuration
public class AnnotationApplicationContextExample {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/a24/config.xml");

        ConsoleMessageRenderer1 consoleRenderer = context.getBean(
                "consoleMessageRenderer1",
                ConsoleMessageRenderer1.class);

        consoleRenderer.renderMessage();

        String name = (String)context.getBean("name");
        System.out.println(name);
    }

}
