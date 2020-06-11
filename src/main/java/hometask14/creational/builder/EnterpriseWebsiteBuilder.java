package hometask14.creational.builder;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder{


    @Override
    void buildName() {
        website.setName("EnterpriseWebsite");

    }

    @Override
    void buildCms() {
        website.setCms(Cms.ALFRESCO);
    }

    @Override
    void buildPrice() {
        website.setPrice(10_000);
    }
}
