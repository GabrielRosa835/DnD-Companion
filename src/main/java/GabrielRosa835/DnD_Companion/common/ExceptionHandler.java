package common;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionHandler {
	private static ExceptionHandler instance;

	public static ExceptionHandler use() {
		return instance == null ? new ExceptionHandler() : instance;
	}

	public void handle(Exception e) {
		e.printStackTrace();
	}
}
