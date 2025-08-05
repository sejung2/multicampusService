package oopException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("정수1 입력: ");
            int num1 = sc.nextInt();
            System.out.print("정수2 입력: ");
            int num2 = sc.nextInt();
            System.out.println("나누기 결과 : " + num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (InputMismatchException e) {
            System.out.println("정수가 아닌 값을 입력했습니다. 정수를 입력해주세요.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다");
        } finally {
            sc.close();
        }
    }
}
