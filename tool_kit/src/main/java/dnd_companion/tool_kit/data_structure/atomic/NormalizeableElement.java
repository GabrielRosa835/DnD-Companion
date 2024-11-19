package dnd_companion.tool_kit.data_structure.atomic;

public abstract class NormalizeableElement<IElement extends NormalizeableElement<IElement>> extends Element 
{
	private double normalizing_factor;
	public double normalizing_factor() {return this.normalizing_factor;}
}