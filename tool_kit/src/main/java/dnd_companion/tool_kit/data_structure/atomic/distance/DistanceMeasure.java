package dnd_companion.tool_kit.data_structure.atomic.distance;

import dnd_companion.tool_kit.data_structure.atomic.Measure;
import dnd_companion.tool_kit.data_structure.atomic.NormalizeableGroup;

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
