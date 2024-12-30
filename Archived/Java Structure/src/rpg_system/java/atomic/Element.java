package atomic;

public interface Element 
{
	public String name();

	public interface NormalizeableElement<ValueType> extends Element {
		public ValueType normalizing_factor();
	}
}
