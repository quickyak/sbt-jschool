package spring.a20;

import org.springframework.stereotype.Component;

@Component
public class ConsoleMessageRenderer {

    public void renderMessage() {
        System.out.println("Message from ConsoleMessageRenderer.");
    }

}
