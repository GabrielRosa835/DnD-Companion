package dnd_companion.local_storage.data.manipulation.archived.atomic.templates;

public interface ConvertibleGroup<IElement, IGroup>
{
	public abstract IGroup convert_to(IElement element);
}
