package atomic.weight;

import java.util.Collection;

import atomic.GroupManager;

public class WeightManager extends GroupManager<Weight, WeightMeasure, WeightManager> 
{
	public WeightManager() {
        super();
    }
    public WeightManager(Collection<WeightMeasure> weight_groups) {
    	super(weight_groups);
    }
    public WeightManager(WeightManager weight_manager) {
        super(weight_manager);
    }
	
	@Override
	protected void remove_element(WeightMeasure weight_measure) {
		Weight weight = weight_measure.element();
        if (this.mapping.containsKey(weight)) {
            WeightMeasure existing_weight_measure = this.mapping.get(weight);
            double new_value = existing_weight_measure.value() - weight_measure.value();
            
            if (new_value > 0) {
            	this.mapping.put(weight, new WeightMeasure(weight, new_value));            	
            } else {
            	this.mapping.remove(weight);            	
            }
        }
    }
	
	@Override
	protected void add_element(WeightMeasure weight_measure) {
		Weight weight = weight_measure.element();
        double value = weight_measure.value();
        
        if (this.mapping.containsKey(weight)) {
        	double new_value = this.mapping.get(weight).value() + value;
        	this.mapping.put(weight, new WeightMeasure(weight, new_value));        	
        } else {        	
        	this.mapping.put(weight, new WeightMeasure(weight, value));
        }
    }
}
