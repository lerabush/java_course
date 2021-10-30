import java.util.function.BiPredicate;

public interface BiPredicateLambdaExpression<T,U> extends BiPredicate<T,U> {
    boolean test(T t, U u);
}
