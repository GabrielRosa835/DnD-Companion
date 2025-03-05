package GabrielRosa835;

import java.util.Arrays;

public interface ToolBox {
	static void print(String message) {
		System.out.println(message);
	}

	static void print(String main_message, Object... params) {
		System.out.printf((main_message) + "%n", params);
	}

	static String toSnakeCase(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}

	static String[] toSnakeCase(String... input) {
		return Arrays.stream(input).map(ToolBox::toSnakeCase).toArray(String[]::new);
	}

	static String capitalize(String text) {
		return Character.toUpperCase(text.charAt(0)) + text.substring(1);
	}
}
