package dnd_companion.tool_kit.data_management;

public class DataUtils 
{
	public static String id_constructor (String collection_name, String file_name) {
		return String.format(collection_name.toLowerCase(), file_name.toLowerCase());
	}
}
