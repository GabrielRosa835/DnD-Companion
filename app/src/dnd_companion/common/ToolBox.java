package dnd_companion.common;

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

	public static String to_snake_case(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}
	public static String[] to_snake_case(String[] input) {
		return Arrays.stream(input).map(s -> to_snake_case(s)).toArray(String[]::new);
	}
}
