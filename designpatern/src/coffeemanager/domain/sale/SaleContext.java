package coffeemanager.domain.sale;

import coffeemanager.domain.order.Order;
import coffeemanager.domain.payment.Payment;

public class SaleContext {

    public Payment init(Order order) {
        order.proceed();
        Payment payment = new Payment(order);
        payment.proceed();
        return payment;
    }
}
