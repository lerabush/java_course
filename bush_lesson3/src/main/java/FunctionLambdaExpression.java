import java.util.function.Function;

public interface FunctionLambdaExpression<T,R> extends Function<T,R> {
    R apply(T t);
}
