package dnd_companion.local_storage.data.manipulation.weight;

import java.util.Collection;

import dnd_companion.local_storage.data.manipulation.AbstractManager;
import dnd_companion.local_storage.data.structure.units.WeightUnit;

public class WeightManager extends AbstractManager<WeightUnit, Weight, WeightManager> 
{
	public WeightManager() {
        super();
    }
    public WeightManager(Collection<Weight> weight_groups) {
    	super(weight_groups);
    }
    public WeightManager(WeightManager weight_manager) {
        super(weight_manager);
    }
	
	@Override
	protected void remove(Weight weight) {
		WeightUnit unit = weight.unit();
		
        if (this.mapping.containsKey(unit)) {
            Weight existing_weight = this.mapping.get(unit);
            double new_value = existing_weight.value() - weight.value();
            
            if (new_value > 0) {
            	this.mapping.put(unit, new Weight(new_value, unit.name()));            	
            } else {
            	this.mapping.remove(unit);            	
            }
        }
    }
	
	@Override
	protected void add(Weight weight) {
		WeightUnit unit = weight.unit();
        double value = weight.value();
        
        if (this.mapping.containsKey(unit)) {
        	double new_value = this.mapping.get(unit).value() + value;
        	this.mapping.put(unit, new Weight(new_value, unit.name()));        	
        } else {        	
        	this.mapping.put(unit, new Weight(value, unit.name()));
        }
    }
}
