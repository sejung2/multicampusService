package coffeemanager.domain.discount.policy;

import coffeemanager.domain.order.Order;

public abstract class DiscountPolicy {

    public int calculatePaymentPrice(Order order) {
        return order.getOrderPrice() - getDiscountAmount(order);
    }
    protected abstract int getDiscountAmount(Order order);
}
