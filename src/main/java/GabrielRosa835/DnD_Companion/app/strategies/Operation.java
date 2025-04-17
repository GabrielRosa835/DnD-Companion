package app.strategies;

import java.util.function.Supplier;

@FunctionalInterface
public interface Operation<ReturnType>
	extends
		Strategy<Void, ReturnType>,
		Supplier<ReturnType>
{
	ReturnType process ();

	default ReturnType execute(Void unused) {
		return process();
	}
	default ReturnType get() {
		return process();
	}
}
