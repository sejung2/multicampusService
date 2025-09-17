package kr.seing.practice.com.di.spring_di_xml_contructor_ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TvMain {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext("application-context1_1.xml");

        Tv tv = (Tv) context.getBean("tv");
        tv.volumeUp();
        tv.volumeDown();

        context.close();
    }
}
