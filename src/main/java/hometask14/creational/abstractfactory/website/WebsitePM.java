package hometask14.creational.abstractfactory.website;

import hometask14.creational.abstractfactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages website project ...");
    }
}
