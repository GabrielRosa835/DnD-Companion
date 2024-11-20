package dnd_companion.game_helper.utils;

public class ToolBox 
{
	public static void print(String main_message, Object... params) {
		System.out.println(String.format(main_message, params));
	}
	public static void print_err(Exception exception) {
		System.err.println(String.format("ERROR: ", exception.getMessage()));
	}
	public static String to_snake_case(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}
}
