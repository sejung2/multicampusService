//package coffeemanager.presentation;
//
//// presentation: 표현계층
//// 서비스 외부의 요청을 받고 응답을 보내는 계층
//
//import coffeemanager.domain.account.Account;
//import coffeemanager.domain.coffee.Coffee;
//import coffeemanager.domain.order.Order;
//import coffeemanager.domain.payment.Payment;
//import coffeemanager.domain.sale.SaleContext;
//
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//
//// business Layer
//// persistence layer => JDBC
//public class Menu {
//
//    private SaleContext saleContext = new SaleContext();
//    private Coffee[] coffees;
//    private Account account = Account.getInstance();
//    private Payment
//
//    public Menu(Coffee[] coffees) {
//        super();
//        this.coffees = coffees;
//        this.account = account;
//    }
//
//    public void menu() {
//
//        while (true) {
//
//            try {
//                Scanner sc = new Scanner(System.in);
//
//                System.out.println("\n==== menu ====\n");
//                System.out.println("판매등록(1)");
//                System.out.println("현황(2)");
//                System.out.println("종료(3)");
//
//                System.out.print("입력 : ");
//                int menu = sc.nextInt();
//
//                if (menu == 3) {
//                    System.out.println("system : 종료합니다.");
//                    break;
//                }
//
//                if (menu < 1 || menu > 3) {
//                    System.out.println("system : 잘못 입력하셨습니다.");
//                    continue;
//                }
//
//                if (menu == 1) {
//                    System.out.println("\n==== list ====\n");
//                    for (int i = 0; i < coffees.length; i++) {
//                        System.out.println(coffees[i].getName() + "(" + i + ")");
//                    }
//
//                    System.out.print("번호 : ");
//                    int drinkNo = sc.nextInt();
//                    System.out.print("수량 : ");
//                    int orderCnt = sc.nextInt();
//
//                    if (drinkNo < 0 || drinkNo >= coffees.length) {
//                        System.out.println("잘못 입력하셨습니다.");
//                        continue;
//                    }
//
//                    registOrder(drinkNo, orderCnt);
//                } else {
//
//                    for (int i = 0; i < coffees.length; i++) {
//                        System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n",
//                                coffees[i].getName(), coffees[i].getStock(), coffees[i].getSalesCnt());
//                    }
//
//                    System.out.printf("잔고 : %4d | 매출 : %8d | 지출 %8d \n"
//                            , account.getBalance(), account.getSales(), account.getExpences());
//                }
//
//            } catch (NoSuchElementException e) {
//                System.out.println("잘못된 입력 값 입니다.");
//                continue;
//            }
//        }
//    }
//
//    private void registOrder(int drinkNo, int orderCnt) {
//        // TODO 주문객체 생성 및 context 로 전달
//        Order order = Order.createOrder(coffees[drinkNo], orderCnt);
//
//        if (order.getStatus().isFail()) {
//            System.out.println("system : 주문생성에 실패하였습니다." + order.getStatus().desc());
//            return;
//        }
//
//        saleContext.init(order);
//
//        System.out.println("\n 제품명 : " + coffees[drinkNo].getName()
//                + "\n 판매가 : " + coffees[drinkNo].getPrice()
//                + "\n 판매수량 : " + orderCnt
//                + "\n 결재금액 : " + payment.getPaymentPrice();
//                + "\n 남은 재고 : " + coffees[drinkNo].getStock());
//    }
//
//
//}
