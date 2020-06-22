package spring.a44;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = "spring/a44/hen.properties", encoding = "UTF-8")
@ComponentScan("spring.a44.house")
//@ImportResource("context.xml")
//@Import(Config.class)
public class Config {

    @Bean
    @Scope("prototype")
    public Egg egg() {
        return new Egg();
    }

    @Bean
    public Hen hen1(@Value("${hen1.name}") String name, Egg egg) {
        Hen hen = new Hen(name);
        hen.setEgg(egg);
        return hen;
    }

    @Bean
    public Hen hen2(@Value("${hen2.name}") String name, Egg egg) {
        Hen hen = new Hen(name);
        hen.setEgg(egg);
        return hen;
    }

    @Bean
    public Hen hen3(@Value("${hen3.name}") String name, Egg egg) {
        Hen hen = new Hen(name);
        hen.setEgg(egg);
        return hen;
    }
}
