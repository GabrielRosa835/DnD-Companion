package atomic;

public interface Convertible<IElement, IGroup>
{
	public void convert_to(IElement element);
	public IGroup convert_new(IElement element);
}
