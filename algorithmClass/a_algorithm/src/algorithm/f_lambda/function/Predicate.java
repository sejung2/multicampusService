package algorithm.f_lambda.function;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
