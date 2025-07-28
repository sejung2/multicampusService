package randomEx;

import java.util.Scanner;

public class BreakEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 100000; // 현재 보유 금액

        System.out.println("현재 잔액 : " + balance);
        while (balance > 0){
            System.out.print("인출액 입력 : ");
            int withdrawal = scanner.nextInt();
            if ((balance - withdrawal) < 0) {
                System.out.println("잔액 부족. 현재 잔액 : " + balance);
                break;
            } else balance -= withdrawal;
        }
        scanner.close();
    }
}
