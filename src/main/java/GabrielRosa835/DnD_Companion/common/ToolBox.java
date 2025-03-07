package common;

import lombok.experimental.*;

import java.util.Arrays;

@UtilityClass
public class ToolBox {
	public void print(String message) {
		System.out.println(message);
	}

	public void print(String main_message, Object... params) {
		System.out.printf((main_message) + "%n", params);
	}

	public String toSnakeCase(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}

	public String[] toSnakeCase(String... input) {
		return Arrays.stream(input).map(ToolBox::toSnakeCase).toArray(String[]::new);
	}

	public String capitalize(String text) {
		return Character.toUpperCase(text.charAt(0)) + text.substring(1);
	}

	public int randomInt(int min, int max) {
		return (int) ((max - min) * Math.random()) + min;
	}
}
