package dnd_companion.local_storage.data.manipulation.archived.atomic.templates;

public abstract class Group<IElement extends Element>
{
	protected IElement element;
	public IElement element() {return this.element;}
}
