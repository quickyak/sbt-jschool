package spring.a44.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import spring.a44.Hen;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HenHouse {

    @Autowired
    private Environment environment;

    private List<Hen> hens = new ArrayList<>();

    @Autowired
    public HenHouse(List<Hen> hens) {
        this.hens = hens;
    }

    public void printHens() {
        for (Hen hen : hens) {
            hen.printYourself();
        }
    }

    public String getProperty() {
        return environment.getProperty("myParameter");
    }
}
