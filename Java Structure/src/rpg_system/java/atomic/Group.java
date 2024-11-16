package atomic;

public abstract class Group<IElement extends Element>
{
	protected IElement element;
	public IElement element() {return this.element;}
	
	public interface NormalizeableGroup<ValueType, IElement, IGroup> extends Convertible<IElement, IGroup>
	{
		public ValueType normalized();
	}
}
