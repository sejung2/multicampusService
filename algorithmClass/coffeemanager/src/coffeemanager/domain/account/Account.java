package coffeemanager.domain.account;

public class Account {

    private int balance = 100000; // 잔고
    private int sales; // 매출
    private int expences; // 지출
    private static Account instance; // 잔고의 싱글턴 인스턴스(전역적으로 사용됨)

    private Account(int balance) {
        this.balance = balance;
    }

    public static Account getInstance() {
        return getInstance(0);
    }

    public static Account getInstance(int balance) {
        if (instance == null) {
            instance = new Account(balance);
        }
        return instance;
    }

    public int getBalance() {
        return balance;
    }

    public int getSales() {
        return sales;
    }

    public int getExpences() {
        return expences;
    }

    public void registSales(int price) { // 판매 등록
        this.balance += price;
        this.sales += price;
    }

    public boolean registExpenses(int price) { // 지출 등록
        if (price > balance) {
            return false;
        }

        this.balance -= price;
        this.expences += price;
        return true;
    }
}
