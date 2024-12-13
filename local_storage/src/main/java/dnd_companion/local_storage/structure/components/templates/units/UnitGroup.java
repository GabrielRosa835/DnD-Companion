package dnd_companion.local_storage.structure.components.templates.units;

public interface UnitGroup<T extends UnitGroup<T, U>, U extends UnitComponent>
{
	public double value();
	public U unit();
	public T convert_to(String unit_name);
}
