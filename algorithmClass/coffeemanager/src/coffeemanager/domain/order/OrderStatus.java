package coffeemanager.domain.order;

import coffeemanager.domain.coffee.Coffee;
import coffeemanager.domain.coffee.SeasonCoffee;
import coffeemanager.domain.purchase.Purchase;

public enum OrderStatus {

    OK(200, "주문 생성 성공"),
    FAIL_SOLD_OUT(500, "재고 확보 실패로 인한 주문 취소"),
    FAIL_FORCE(400, "판매자의 강제 주문 취소"),
    FAIL_SEASON(401, "판매 시즌이 아닙니다");

    private int code;
    private String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatus determineStatus(Order order) {
        int orderCnt = order.getOrderCnt();
        Coffee coffee = order.getCoffee();

        if (orderCnt > coffee.getStock()) {
            Purchase purchase = new Purchase(coffee, orderCnt);
            if (!purchase.proceed()) {
                return FAIL_SOLD_OUT;
            }
        }

        if (coffee instanceof SeasonCoffee seasonCoffee) {
            if (!seasonCoffee.isSeason()) {
                return FAIL_SEASON;
            }
        }
        return OK;
    }

    public boolean isOk() {
        return code == 200;
    }

    public boolean isFail() {
        return code != 200;
    }

    public String desc() {
        return desc;
    }

    public int code() {
        return code;
    }
}
