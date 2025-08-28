package coffeemanager.domain.multiligual.payment.translate;

public interface Translatable<T> {

    String translate();
    T origin();
}
