package coffeemanager.domain.multiligual.payment.translate;

import coffeemanager.domain.payment.Payment;

public abstract class PaymentDecorator implements Translatable<Payment> {

    protected Translatable<Payment> target;

    public PaymentDecorator(Translatable<Payment> target) {
        this.target = target;
    }


}
