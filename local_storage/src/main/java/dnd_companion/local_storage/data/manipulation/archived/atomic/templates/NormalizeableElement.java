package dnd_companion.local_storage.data.manipulation.archived.atomic.templates;

public abstract class NormalizeableElement<IElement extends NormalizeableElement<IElement>> extends Element 
{
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
}