package kr.seing.practice.sec03.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // proxy에 해당
public class PerformanceAspect {

    // where: 어디에 적용(패키지내 모든 메서드에 적용)
    @Pointcut("within(kr.seing.practice.sec03.annotation.*)")
    private void pointcutMethod() {

    }

    @Around("pointcutMethod()")
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
            result = joinPoint.proceed(); // 핵심기능 메소드 호출
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
