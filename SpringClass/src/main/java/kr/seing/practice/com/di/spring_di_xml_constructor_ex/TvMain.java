package kr.seing.practice.com.di.spring_di_xml_constructor_ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TvMain {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("application-context1_1.xml");

        Tv tv = (Tv) context.getBean("tv");
        tv.volumeUp();
        tv.volumeDown();

        context.close();
    }
}
