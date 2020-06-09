package hometask14.creational.abstractfactory.banking;

import hometask14.creational.abstractfactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code ....");
    }
}
