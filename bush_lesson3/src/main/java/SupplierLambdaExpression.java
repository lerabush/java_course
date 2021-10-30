import java.util.List;
import java.util.function.Supplier;

public interface SupplierLambdaExpression<T> extends Supplier<T> {
   T get();
}
