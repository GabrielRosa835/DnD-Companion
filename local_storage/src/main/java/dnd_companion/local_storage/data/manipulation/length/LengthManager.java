package dnd_companion.local_storage.data.manipulation.length;

import java.util.Collection;

import dnd_companion.local_storage.data.manipulation.AbstractManager;
import dnd_companion.local_storage.data.structure.units.LengthUnit;

public class LengthManager extends AbstractManager<LengthUnit, Length, LengthManager> 
{
	public LengthManager() {
        super();
    }
    public LengthManager(Collection<Length> length) {
    	super(length);
    }
    public LengthManager(LengthManager length_manager) {
        super(length_manager);
    }
	
	@Override
	protected void remove(Length length) {
		LengthUnit unit = length.unit();
        if (this.mapping.containsKey(unit)) {
            Length existing_length = this.mapping.get(unit);
            double new_value = existing_length.value() - length.value();
            
            if (new_value > 0) {
            	this.mapping.put(unit, new Length(new_value, unit.name()));            	
            } else {
            	this.mapping.remove(unit);            	
            }
        }
    }
	
	@Override
	protected void add(Length length) {
		LengthUnit unit = length.unit();
        double value = length.value();
        
        if (this.mapping.containsKey(unit)) {
        	double new_value = this.mapping.get(unit).value() + value;
        	this.mapping.put(unit, new Length(new_value, unit.name()));        	
        } else {        	
        	this.mapping.put(unit, new Length(value, unit.name()));
        }
    }
}
