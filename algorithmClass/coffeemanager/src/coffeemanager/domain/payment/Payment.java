package coffeemanager.domain.payment;


import coffeemanager.domain.account.Account;
import coffeemanager.domain.discount.policy.DiscountPolicy;
import coffeemanager.domain.multiligual.payment.translate.Translatable;
import coffeemanager.domain.order.Order;

public class Payment implements Translatable<Payment> {

    private Order order; //
    private int paymentPrice;
    private DiscountPolicy discountPolicy;

    public Payment(Order order, DiscountPolicy discountPolicy) {
        this.order = order;
        this.discountPolicy = discountPolicy;
        this.paymentPrice = discountPolicy.calculatePaymentPrice(order);
    }

    public Order getOrder() {
        return order;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void proceed() {
        Account account = Account.getInstance();
        account.registSales(paymentPrice);
    }

    @Override
    public String translate() {
        String info = order.getName() + "잔"
                + "\n" + paymentPrice + "원";
        return info;
    }

    public String getOrderName() {
        return order.getName();
    }

    @Override
    public Payment origin() {
        return this;
    }
}
