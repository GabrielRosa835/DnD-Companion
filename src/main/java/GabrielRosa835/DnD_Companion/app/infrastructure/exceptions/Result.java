package app.infrastructure.exceptions;

import java.util.*;

public class Result<V, X extends Exception> {

	private final V value;
	private final X error;

	private Result (V value, X error) {
		this.value = value;
		this.error = error;
	}

	public Optional<V> value () {
		return Optional.ofNullable(value);
	}

	public Optional<X> error () {
		return Optional.ofNullable(error);
	}

	public static <V, X extends Exception> Result<V, X> success (V value) {
		return new Result<>(value, null);
	}
	public static <V, X extends Exception> Result<V, X> failure (X error) {
		return new Result<>(null, error);
	}
}
