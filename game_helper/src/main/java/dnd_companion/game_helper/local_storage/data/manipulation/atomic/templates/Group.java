package dnd_companion.game_helper.local_storage.data.manipulation.atomic.templates;

public abstract class Group<IElement extends Element>
{
	protected IElement element;
	public IElement element() {return this.element;}
}
