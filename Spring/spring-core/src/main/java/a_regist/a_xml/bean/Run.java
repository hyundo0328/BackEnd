package a_regist.a_xml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext(
            "/regist/xml/bean/application-context.xml"
        );

        Book book = context.getBean("harrypoter", Book.class);
        System.out.println(book);
        
        Book ring = context.getBean("ringOfKing", Book.class);
        System.out.println(ring);
    }
}
