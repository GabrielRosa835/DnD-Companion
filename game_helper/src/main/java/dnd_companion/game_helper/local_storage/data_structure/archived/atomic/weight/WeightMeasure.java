package dnd_companion.game_helper.local_storage.data_structure.archived.atomic.weight;

import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.Measure;
import dnd_companion.game_helper.local_storage.data_structure.archived.atomic.NormalizeableGroup;

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
