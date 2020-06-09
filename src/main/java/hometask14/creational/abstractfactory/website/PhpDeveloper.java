package hometask14.creational.abstractfactory.website;

import hometask14.creational.abstractfactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes php code ...");
    }
}
