package hometask14.creational.abstractfactory.website;

import hometask14.creational.abstractfactory.Developer;
import hometask14.creational.abstractfactory.ProjectManager;
import hometask14.creational.abstractfactory.ProjectTeamFactory;
import hometask14.creational.abstractfactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {

    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
