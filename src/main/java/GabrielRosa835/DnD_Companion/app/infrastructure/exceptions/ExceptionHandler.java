package app.infrastructure.exceptions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionHandler {
	public void handle(Exception e) {
		e.printStackTrace();
	}
}
