package coffeemanager.domain.coffee;

import coffeemanager.domain.purchase.Purchase;

public class Coffee {

    private String name; // 상품 이름
    private int price; // 판매가
    private int purchasePrice; // 매입가
    private int stock; // 재고
    private int safetyStock; // 안전재고
    private int salesCnt; // 판매량

    public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt) {
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.safetyStock = safetyStock;
        this.salesCnt = salesCnt;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getStock() {
        return stock;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public int getSalesCnt() {
        return salesCnt;
    }

    public void provide(int cnt) {
        deductStock(cnt);
        addSalesCnt(cnt);
        checkSafetyStock();
    }

    private void checkSafetyStock() { // 안전재고 확인
        if (stock <= safetyStock) { // 재고가 안전재고보다 적으면
            Purchase purchase = new Purchase(this, safetyStock * 2); // 안전재고의 2배만큼 구매

            if (purchase.proceed()) {
                System.out.println("system : 안전재고 확보에 성공했습니다.");
                return;
            }

            System.out.println("system : 안전재고 확보에 실패했습니다.");
        }
    }

    private void addSalesCnt(int cnt) { // 판매량 증가
        this.salesCnt += cnt;
    }

    private void deductStock(int cnt) { // 재고량 감소
        this.stock -= cnt;
    }

    public void addStock(int cnt) { // 재고량 증가
        this.stock += cnt;
    }
}
