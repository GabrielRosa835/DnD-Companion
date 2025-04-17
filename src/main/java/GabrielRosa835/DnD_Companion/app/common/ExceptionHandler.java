package app.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionHandler {
	public void handle (Exception e) {
		e.printStackTrace();
	}
}
