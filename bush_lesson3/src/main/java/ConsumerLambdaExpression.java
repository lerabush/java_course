import java.util.function.Consumer;

public interface ConsumerLambdaExpression<T> extends Consumer<T> {
    void accept(T t);
}
