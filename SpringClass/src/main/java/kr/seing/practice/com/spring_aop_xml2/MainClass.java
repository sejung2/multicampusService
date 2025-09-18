package kr.seing.practice.com.spring_aop_xml2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("sec02/application-config1-2.xml");

        Evaluation eval = context.getBean("evaluation", Evaluation.class);
        eval.average();
        eval.total();

        Circle circle = context.getBean("circle", Circle.class);
        circle.area();
        circle.round();
    }
}
