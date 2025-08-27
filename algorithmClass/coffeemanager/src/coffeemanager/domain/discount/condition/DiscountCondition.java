package coffeemanager.domain.discount.condition;

import coffeemanager.domain.order.Order;

public interface DiscountCondition {
    boolean isSatisfied(Order order);
}
