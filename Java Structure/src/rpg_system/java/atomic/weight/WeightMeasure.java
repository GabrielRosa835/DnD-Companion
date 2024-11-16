package atomic.weight;

import atomic.Measure;
import atomic.Group.NormalizeableGroup;

public class WeightMeasure extends Measure<Weight> implements NormalizeableGroup<Double, Weight, WeightMeasure>
{
	public WeightMeasure(Weight weight, double value) {
		this.element = weight;
		this.value = value;
	}

	@Override
	public void convert_to(Weight weight) {
		this.value = this.normalized() / this.element.normalizing_factor();
		this.element = weight;
	}

	@Override
	public WeightMeasure convert_new(Weight weight) {
		return new WeightMeasure(this.element, this.normalized() / weight.normalizing_factor());
	}

	@Override
	public Double normalized() {
		return value * this.element.normalizing_factor();
	}
}
