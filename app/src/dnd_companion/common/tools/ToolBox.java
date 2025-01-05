package dnd_companion.common.tools;

import java.util.Arrays;

public class ToolBox
{	
	public void print(String message) {
		System.out.println(message);
	}
	public void print(String main_message, Object... params) {
		System.out.println(String.format(main_message, params));
	}
	public void print(Exception exception) {
		exception.printStackTrace();
	}

	public String to_snake_case(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}
	public String[] to_snake_case(String[] input) {
		return Arrays.stream(input).map(s -> to_snake_case(s)).toArray(String[]::new);
	}
	
	public String to_file_name(String name) {
		return this.to_snake_case(name).concat(".json");
	}
}
