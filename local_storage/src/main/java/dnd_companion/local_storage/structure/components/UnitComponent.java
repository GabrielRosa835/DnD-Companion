package dnd_companion.local_storage.structure.components;

public interface UnitComponent
{
	public double value();
	public UnitOption unit();
	public UnitComponent convert_to(String unit_name);
	
	public interface UnitOption
	{
		public String name();
		public String abbreviation();
		public double normalizing_factor();
	}
}
