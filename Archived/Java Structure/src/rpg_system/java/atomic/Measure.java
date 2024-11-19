package atomic;

public abstract class Measure<MeasureElement extends Element> extends Group<MeasureElement>
{
	protected MeasureElement element;
	public MeasureElement element() {return this.element;}
	
	protected double value;		
	public double value() {return this.value;}
	
	public void increase_amount(double d) {
		this.value += d;
	}
	public void decrease_amount(double d) {
		this.value -= d;
		if (this.value < 0) 
			this.value = 0;
	}
}