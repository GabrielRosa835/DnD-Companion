package dnd_companion.game_helper.local_storage.data_structure.archived.atomic;

public interface ConvertibleGroup<IElement, IGroup>
{
	public abstract IGroup convert_to(IElement element);
}
