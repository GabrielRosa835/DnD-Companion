package dnd_companion.game_helper.local_storage.data.manipulation.atomic.templates;

public abstract class NormalizeableGroup
<IElement extends NormalizeableElement<IElement>, IGroup extends NormalizeableGroup<IElement, IGroup>> 
implements ConvertibleGroup<IElement, IGroup>
{
	protected Element element;
	public Element element() {return this.element;}
	
	protected double value;		
	public double value() {return this.value;}
	
	public void increase_value(double d) {
		this.value += d;
	}
	public double decrease_value(double d) {
	    this.value = (this.value - d < 0) ? 0 : this.value - d;
	    return this.value;
	}
	
	public abstract IElement normalized();
}