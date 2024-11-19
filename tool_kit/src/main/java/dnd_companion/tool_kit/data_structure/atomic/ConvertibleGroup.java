package dnd_companion.tool_kit.data_structure.atomic;

public interface ConvertibleGroup<IElement, IGroup>
{
	public abstract IGroup convert_to(IElement element);
}
