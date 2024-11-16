package atomic.distance;

import atomic.Measure;
import atomic.Group.NormalizeableGroup;

public class DistanceMeasure extends Measure<Distance> implements NormalizeableGroup<Double, Distance, DistanceMeasure>
{	
	public DistanceMeasure(Distance distance, double value) {
		this.element = distance;
		this.value = value;
	}

	@Override 
	public void convert_to(Distance distance) {
		this.value = this.normalized() / this.element.normalizing_factor();
		this.element = distance;
	}

	@Override 
	public DistanceMeasure convert_new(Distance distance) {
		return new DistanceMeasure(this.element, this.normalized() / distance.normalizing_factor());
	}

	@Override 
	public Double normalized() {
		return value * this.element.normalizing_factor();
	}
}
