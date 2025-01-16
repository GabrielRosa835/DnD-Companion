package dnd_companion.common.tools;

import java.util.Arrays;

public class ToolBox
{	
	public static void print(String message) {
		System.out.println(message);
	}
	public static void print(String main_message, Object... params) {
		System.out.println(String.format(main_message, params));
	}
	public static void print(Exception exception) {
		exception.printStackTrace();
	}

	public static String toSnakeCase(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}
	public static String[] toSnakeCase(String[] input) {
		return Arrays.stream(input).map(s -> toSnakeCase(s)).toArray(String[]::new);
	}
	
	public static String toFileName(String name) {
		return toSnakeCase(name).concat(".json");
	}
}
