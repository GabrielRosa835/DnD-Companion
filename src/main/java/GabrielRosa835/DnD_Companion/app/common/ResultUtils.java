package app.common;


import co.unruly.control.result.*;

import java.util.function.*;

public interface ResultUtils {

	static <I, O> Function<I, O> nullify() {
		return input -> null;
	}
	static <S, F> void printResult(Result<S, F> result) {
		result.either(
				s -> {System.out.println(s.toString());return null;},
				f -> {System.out.println(f.toString());return null;});
	}
}
