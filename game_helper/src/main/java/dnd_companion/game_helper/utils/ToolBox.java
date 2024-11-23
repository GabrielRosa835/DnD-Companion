package dnd_companion.game_helper.utils;

import java.lang.reflect.Field;

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
	public static <T> T to_snake_case_all(T object) {
        if (object == null) {
            return null;
        }

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(String.class)) {
                field.setAccessible(true);
                try {
                    String value = (String) field.get(object);
                    if (value != null) {
                        field.set(object, to_snake_case(value));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
