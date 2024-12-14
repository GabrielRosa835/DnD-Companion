package dnd_companion.local_storage.common;

import java.util.Arrays;

import dnd_companion.local_storage.storage.StorageMetadata;
import dnd_companion.local_storage.structure.data.Data;

public class ToolBox
{
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

	public static String create_file_path(DataKey key) {
		String dir_path = StorageMetadata.directory_hierarquy.get(key.collection()).path();
		return dir_path + "\\" + ToolBox.to_snake_case(key.file_name()) + ".json";
	}
	public static String create_file_path(Data data) {
		String dir_path = StorageMetadata.directory_hierarquy.get(data.collection()).path();
		return dir_path + "\\" + ToolBox.to_snake_case(data.file_name()) + ".json";
	}
	public static String create_file_path(String collection) {
		return StorageMetadata.directory_hierarquy.get(collection).path();
	}

	public static String get_simple_name_from_full(String type_name) {
        if (type_name == null || type_name.isEmpty()) {
            return "";
        }
        String[] elements = type_name.split("\\.");
        return elements[elements.length - 1];
    }
	
	public static String exlude_file_extension(String file_name) {
		int dot_index = file_name.lastIndexOf('.');
		String name_without_extension = (dot_index == -1) ? file_name : file_name.substring(0, dot_index);
		return name_without_extension; 
	}
}
