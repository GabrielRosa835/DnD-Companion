package app.common.functions;

import co.unruly.control.result.*;

import java.util.function.*;

import static co.unruly.control.result.Introducers.tryTo;
import static co.unruly.control.result.Transformers.attempt;

@FunctionalInterface
public interface Operation<Input, Output> extends Function<Input, Result<Output, Exception>>
{
	Output process (Input input) throws Exception;

	@Override default Result<Output, Exception> apply(Input input) {
		return Result.success(input, Exception.class)
				.then(attempt(tryTo(this::process)));
	}
}
