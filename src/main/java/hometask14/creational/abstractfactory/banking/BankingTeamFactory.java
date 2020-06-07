package hometask14.creational.abstractfactory.banking;

import hometask14.creational.abstractfactory.Developer;
import hometask14.creational.abstractfactory.ProjectManager;
import hometask14.creational.abstractfactory.ProjectTeamFactory;
import hometask14.creational.abstractfactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
