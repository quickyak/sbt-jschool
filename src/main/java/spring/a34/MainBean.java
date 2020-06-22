package spring.a34;

public class MainBean {

    private DependencyBean dependencyBean;
    private DependencyPropertyBean dependencyPropertyBean;

    public MainBean() {
    }

    public MainBean(DependencyBean dependencyBean) {
        this.dependencyBean = dependencyBean;
    }

    public DependencyBean getDependencyBean() {
        return dependencyBean;
    }

    public void setDependencyPropertyBean(DependencyPropertyBean dependencyPropertyBean) {
        this.dependencyPropertyBean = dependencyPropertyBean;
    }

    public DependencyPropertyBean getDependencyPropertyBean() {
        return dependencyPropertyBean;
    }

    public void setDependencyBean(DependencyBean dependencyBean) {
        this.dependencyBean = dependencyBean;
    }
}
