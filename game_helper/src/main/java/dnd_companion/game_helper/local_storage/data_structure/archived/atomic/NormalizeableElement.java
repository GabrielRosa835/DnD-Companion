package dnd_companion.game_helper.local_storage.data_structure.archived.atomic;

public abstract class NormalizeableElement<IElement extends NormalizeableElement<IElement>> extends Element 
{
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
}