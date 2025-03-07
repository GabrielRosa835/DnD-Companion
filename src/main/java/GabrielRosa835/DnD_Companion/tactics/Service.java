package tactics;

import elements.models.*;

public interface Service<ReturnType> extends Tactic
{
	@Override Service<ReturnType> execute();
	Service<ReturnType> loadElements(Element... elements);
	public ReturnType result();

	interface Applicable {
		public Service<?> useService(Service<?> service);
	}
}
