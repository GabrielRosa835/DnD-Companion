package atomic.distance;

import java.util.Collection;

import atomic.GroupManager;

public class DistanceManager extends GroupManager<Distance, DistanceMeasure, DistanceManager> 
{
	public DistanceManager() {
        super();
    }
    public DistanceManager(Collection<DistanceMeasure> distance_groups) {
    	super(distance_groups);
    }
    public DistanceManager(DistanceManager distance_manager) {
        super(distance_manager);
    }
	
	@Override
	protected void remove_element(DistanceMeasure distance_measure) {
		Distance distance = distance_measure.element();
        if (this.mapping.containsKey(distance)) {
            DistanceMeasure existing_distance_measure = this.mapping.get(distance);
            double new_value = existing_distance_measure.value() - distance_measure.value();
            
            if (new_value > 0) {
            	this.mapping.put(distance, new DistanceMeasure(distance, new_value));            	
            } else {
            	this.mapping.remove(distance);            	
            }
        }
    }
	
	@Override
	protected void add_element(DistanceMeasure distance_measure) {
		Distance distance = distance_measure.element();
        double value = distance_measure.value();
        
        if (this.mapping.containsKey(distance)) {
        	double new_value = this.mapping.get(distance).value() + value;
        	this.mapping.put(distance, new DistanceMeasure(distance, new_value));        	
        } else {        	
        	this.mapping.put(distance, new DistanceMeasure(distance, value));
        }
    }
}
