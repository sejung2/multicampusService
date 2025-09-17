package kr.seing.practice.di.spring_di_xml_setter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NameMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2.xml");
        NameController control = context.getBean("nameController", NameController.class);
        control.show("홍길동");
    }
}
