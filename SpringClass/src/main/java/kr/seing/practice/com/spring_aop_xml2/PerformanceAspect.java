package kr.seing.practice.com.spring_aop_xml2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        // JoinPoint : 특정 포인트(핵심 기능 메소드 호출 시 삽입)
        Signature s =  joinPoint.getSignature(); // 설정되어있는 핵심기능에 대한 정보를 추출
        String methodName = s.getName(); // 핵심기능 메소드명

        long startTime = System.nanoTime();
        Object result = null; // 반환결과 저장 변수

        // 공통작업 코드
        System.out.println("-----------------------------------------------------------------");
        System.out.println("[Log] Before : " + methodName + "() 실행 시작");
        System.out.println("-----------------------------------------------------------------");

        try {
            joinPoint.proceed(); // 핵심기능 메소드 호출
        } catch (Exception e) {
            System.out.println("[Log] Exception : " + e.getMessage());
        }

        long endTime = System.nanoTime();

        System.out.println("-----------------------------------------------------------------");
        System.out.println("[Log] After : " + methodName + "() 실행 종료");
        System.out.println("[Log] After : " + methodName + "() 실행시간: " + (endTime - startTime) + " ns");
        System.out.println("-----------------------------------------------------------------");


        return result;
    }
}
