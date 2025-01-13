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

	public String toSnakeCase(String input) {
		return (input == null) ? null : input.toLowerCase().replace(" ", "_");
	}
	public String[] toSnakeCase(String[] input) {
		return Arrays.stream(input).map(s -> toSnakeCase(s)).toArray(String[]::new);
	}
	
	public String toFileName(String name) {
		return this.toSnakeCase(name).concat(".json");
	}
}
