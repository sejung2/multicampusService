package algorithm.f_lambda.function;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
