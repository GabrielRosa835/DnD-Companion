package dnd_companion.local_storage.system_components.utils;

import java.util.Arrays;

public class ToolBox 
{
	public static void print(String main_message, Object... params) {
		System.out.println(String.format(main_message, params));
	}
	public static void print_err(Exception exception) {
		String message = (exception.getMessage() == null) ? "No specified message" : exception.getMessage();
		System.err.println(String.format("ERROR: %s", message));
	}
	
	public static String to_snake_case(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}
	public static String[] to_snake_case(String[] input) {
		return Arrays.stream(input).map(s -> to_snake_case(s)).toArray(String[]::new);
	}
}
