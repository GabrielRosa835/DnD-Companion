package app.common.functions;

import co.unruly.control.result.*;

import java.util.function.*;

import static co.unruly.control.result.Introducers.tryTo;
import static co.unruly.control.result.Transformers.attempt;

@FunctionalInterface
public interface Check<T>
	extends
		Operation<T, Boolean>,
		Predicate<T>
{
	boolean validate(T input) throws Exception;

	@Override default Boolean process(T input) throws Exception {return validate(input);}
	@Override default boolean test(T input) {
		return Result.success(null)
				.then(attempt(tryTo(___ -> validate(input))))
				.either(s -> true, f -> false);
	}
}
