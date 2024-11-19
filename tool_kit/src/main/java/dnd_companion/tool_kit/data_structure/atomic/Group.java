package dnd_companion.tool_kit.data_structure.atomic;

public abstract class Group<IElement extends Element>
{
	protected IElement element;
	public IElement element() {return this.element;}
}
