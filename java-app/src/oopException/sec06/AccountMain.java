package oopException.sec06;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        // 예금
        account.deposit(10000);
        System.out.println("예금액 : " + account.getBalance() + "원");

        //출금
        try {
            account.withDraw(30000); // method 구현에 예외를 포함하고 있음, try catch로 처리해야 함
        } catch (BalanceInsufficientException e) {
            String message = e.getMessage(); // 예외 메시지를 가져옴
            System.out.println("출금 실패 - " + message);
            e.printStackTrace();
        }
    }
}
