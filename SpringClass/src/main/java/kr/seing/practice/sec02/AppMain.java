package kr.seing.practice.sec02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        // Spring 컨테이너 구동
        AbstractApplicationContext context = new GenericXmlApplicationContext("sec02/application-config.xml");

        // 핵심 기능 bean 등록되어 있음
        Rect rect = context.getBean("rect", Rect.class);
        rect.showRectResult();

        Gugudan gg = context.getBean("gugudan", Gugudan.class);
        gg.showResult();


    }
}
