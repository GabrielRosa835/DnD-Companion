package dnd_companion.archives.local_storage.structure.models;

public interface ItemProperties 
{
	public String name();
	public double price_value();
	public String price_unit();
	public double weight_value();
	public String weight_unit();
	public String[] tags();
	public String description();
}
