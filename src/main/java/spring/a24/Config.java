package spring.a24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.a20.ConsoleMessageRenderer;

@Configuration
public class Config {

    @Bean
    public ConsoleMessageRenderer myRenderer() {
        return new ConsoleMessageRenderer();
    }

}
