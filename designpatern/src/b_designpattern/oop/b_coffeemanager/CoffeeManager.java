package b_designpattern.oop.b_coffeemanager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CoffeeManager {

    public static void main(String[] args) {

        String americanoName = "아메리카노";
        int americanoPrice = 1000;
        int americanoCost = 500;
        int americanoStock = 10;
        int americanoSafetyStock = 3;
        int americanoSaleCnt = 0;

        String mochaName = "모카";
        int mochaPrice = 1000;
        int mochaCost = 500;
        int mochaStock = 10;
        int mochaSafetyStock = 3;
        int mochaSaleCnt = 0;

        String latteName = "라떼";
        int lattePrice = 1000;
        int latteCost = 500;
        int latteStock = 10;
        int latteSafetyStock = 3;
        int latteSaleCnt = 0;

        int balance = 100000;
        int salesAmount = 0;
        int expenseAmount = 0;

        while (true) {

            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("\n==== menu ====\n");
                System.out.println("판매등록(1)");
                System.out.println("현황(2)");
                System.out.println("종료(3)");

                System.out.print("입력: ");
                int menu = sc.nextInt();

                if (menu == 3) {
                    System.out.println("system: 종료합니다");
                    break;
                }

                if (menu < 1 || menu > 3) {
                    System.out.println("system: 잘못 입력하셨습니다");
                    continue;
                }

                if (menu == 1) {
                    System.out.println("\n==== list ====\n");
                    System.out.println("americano(0)");
                    System.out.println("mocha(1)");
                    System.out.println("latte(2)");

                    System.out.println("번호");
                    int drinkNo = sc.nextInt();
                    System.out.println("수량");
                    int orderCnt = sc.nextInt();

                    if (drinkNo < 1 || drinkNo > 3) {
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                    }

                    if (drinkNo == 0) {
                        // 재고 차감
                        americanoSafetyStock -= orderCnt;
                        // 매출 등록
                        salesAmount += orderCnt * americanoPrice;
                        // 잔고 등록
                        balance += orderCnt * americanoPrice;
                    } else if (drinkNo == 1) {
                        int purchasePrice = orderCnt * americanoCost;
                        if (purchasePrice >= balance) {
                            System.out.println("system: 주문을 취소합니다");
                            continue;
                        }

                        System.out.printf("system: " + americanoName + " " + orderCnt + "개 매입합니다.");
                        // 재고 추가
                        americanoStock += orderCnt;
                        // 지출 등록
                        expenseAmount += purchasePrice;
                        // 잔고 등록
                        balance -= purchasePrice;
                    } else {
                        if (americanoStock <= americanoSafetyStock) {
                            int purchasePrice = americanoStock * 2 * americanoCost;

                            if (balance >= purchasePrice) {
                                americanoStock += americanoSafetyStock * 2;
                                balance -= purchasePrice;
                                expenseAmount += purchasePrice;
                            } else {
                                System.out.println("system: 잔액 부족으로 안전재고 확보 실패");
                            }
                        }
                        System.out.println("\n 제품명: " + americanoName +
                                "");
                    }
                } else {
                    System.out.println("\n==== info ====\n");
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", americanoName, americanoStock, americanoSaleCnt);
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", mochaName, mochaStock, mochaSaleCnt);
                    System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", latteName, latteStock, latteSaleCnt);

                    System.out.printf("잔고 : %4d | 매출: %8d | 지출: %8d \n", balance, salesAmount, expenseAmount);
                }

                // unchecked Exception: 개발자 실수 또는 컨트롤 할 수 있는 상황
            } catch (NoSuchElementException e) {
                System.out.println("system: 잘못 입력하셨습니다");
                break;
            }


        }
    }
}
