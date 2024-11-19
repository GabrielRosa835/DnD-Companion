package atomic;

public abstract class Bundle<BundleElement extends Element> extends Group<BundleElement>
{
	protected int amount;
	public int amount() {return this.amount;}
	
	public void increase_amount(int i) {
		this.amount += i;
	};
	
	public void decrease_amount(int i) {
		this.amount -= i;
		if (this.amount < 0) 
			this.amount = 0;
	};
}
