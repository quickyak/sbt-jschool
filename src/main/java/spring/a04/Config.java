package spring.a04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(TimeProfiler.class)
public class Config {

    @Bean
    public Evaluator evaluator() {
        System.out.println("Bean creating");
        return new Evaluator();
    }
}
