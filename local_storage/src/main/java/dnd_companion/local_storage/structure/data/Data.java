package dnd_companion.local_storage.structure.data;

public interface Data
{
	public String collection();
	public String file_name();
	public String name();
	public Data validate();
	
	public static String file = "data";
}
