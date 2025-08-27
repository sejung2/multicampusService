package coffeemanager.domain.purchase;

import coffeemanager.domain.account.Account;
import coffeemanager.domain.coffee.Coffee;

public class Purchase {

    private Coffee coffee; // 매입할 커피이름
    private int purchaseCnt; // 매입 수량
    private int purchasePrice; // 매입할 가격

    public Purchase(Coffee coffee, int cnt) {
        this.coffee = coffee;
        this.purchaseCnt = cnt;
        this.purchasePrice = coffee.getPurchasePrice() * cnt;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getPurchaseCnt() {
        return purchaseCnt;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public boolean proceed() { // 매입하기
        Account account = Account.getInstance(); // 계좌 불러오기
        if (account.registExpenses(purchasePrice)) { // 매입
            System.out.println("system : " + coffee.getName() + "[" + purchaseCnt + "잔] 매입");
            coffee.addStock(purchaseCnt);
            return true;
        }

        System.out.println("system : 매입에 실패했습니다.");
        return false;
    }
}
