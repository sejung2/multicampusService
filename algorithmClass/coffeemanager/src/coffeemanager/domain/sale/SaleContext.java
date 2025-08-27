package coffeemanager.domain.sale;

import coffeemanager.domain.discount.policy.AmountDiscountPolicy;
import coffeemanager.domain.discount.policy.PercentDiscountPolicy;
import coffeemanager.domain.order.Order;
import coffeemanager.domain.payment.Payment;

public class SaleContext {

    public Payment init(Order order) {
        order.proceed();
        Payment payment = new Payment(order, new AmountDiscountPolicy(500));
        payment.proceed();
        return payment;
    }
}
