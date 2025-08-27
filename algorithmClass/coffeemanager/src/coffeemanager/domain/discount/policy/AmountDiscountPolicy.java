package coffeemanager.domain.discount.policy;

import coffeemanager.domain.discount.condition.DiscountConditionType;
import coffeemanager.domain.order.Order;

public class AmountDiscountPolicy extends DiscountPolicy {

    private int discountAmount;

    public AmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    protected int getDiscountAmount(Order order) {
        for (DiscountConditionType conditionType : DiscountConditionType.values()) {
            if (conditionType.condition().isSatisfied(order)) {
                return discountAmount;
            }
        }
        return 0;
    }
}
