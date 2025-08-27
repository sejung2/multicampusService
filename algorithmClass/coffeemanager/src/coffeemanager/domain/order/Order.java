package coffeemanager.domain.order;

import coffeemanager.domain.coffee.Coffee;

import java.time.OffsetDateTime;

public class Order {

    private String name; //
    private Coffee coffee; // 커피 이름
    private int orderCnt; // 주문 수량
    private int orderPrice; // 주문 가격
    private OffsetDateTime orderTime; // 주문한 시간
    private OrderStatus status; // 주문 상태

    public static Order createOrder(Coffee coffee, int orderCnt) { // 주문 생성

        Order order = new Order(coffee, orderCnt);
        order.status = OrderStatus.determineStatus(order);
        return order;
    }

    private Order(Coffee coffee, int orderCnt) {
        this.name = coffee.getName() + "[" + orderCnt + "]";
        this.coffee = coffee;
        this.orderCnt = orderCnt;
        this.orderPrice = coffee.getPrice() * orderCnt;
        this.orderTime = OffsetDateTime.now();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getOrderCnt() {
        return orderCnt;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public OffsetDateTime getOrderTime() {
        return orderTime;
    }

    public void proceed() {
        coffee.provide(orderCnt);
    }
}
