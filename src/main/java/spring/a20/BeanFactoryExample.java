package spring.a20;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryExample {

    public static void main(String[] args) {
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
//
//        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("spring/a20/config.xml"));

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/a20/config.xml");

        ConsoleMessageRenderer consoleRenderer = context.getBean(
                "consoleRenderer",
                ConsoleMessageRenderer.class);

        consoleRenderer.renderMessage();
    }



}
