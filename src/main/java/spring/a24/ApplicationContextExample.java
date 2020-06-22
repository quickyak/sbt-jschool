package spring.a24;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.a20.ConsoleMessageRenderer;

public class ApplicationContextExample {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/a20/config.xml");

        ConsoleMessageRenderer consoleRenderer = context.getBean(
                "consoleRenderer",
                ConsoleMessageRenderer.class);

        consoleRenderer.renderMessage();
    }

}
