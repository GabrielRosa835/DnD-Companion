package dnd_companion.game_helper.local_storage.data.manipulation.atomic.price;

import java.util.Collection;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.AbstractManager;
import dnd_companion.game_helper.local_storage.data.structure.options.Currency;

public class PriceManager extends AbstractManager<Currency, Price, PriceManager> 
{
	public PriceManager() {
        super();
    }
    public PriceManager(Collection<Price> price) {
    	super(price);
    }
    public PriceManager(PriceManager price_manager) {
        super(price_manager);
    }
	
	@Override
	protected void remove(Price price) {
		Currency unit = price.unit();
        if (this.mapping.containsKey(unit)) {
            Price existing_price = this.mapping.get(unit);
            double new_value = existing_price.value() - price.value();
            
            if (new_value > 0) {
            	this.mapping.put(unit, new Price(new_value, unit.name()));            	
            } else {
            	this.mapping.remove(unit);            	
            }
        }
    }
	
	@Override
	protected void add(Price price) {
		Currency unit = price.unit();
		double value = price.value();
        
        if (this.mapping.containsKey(unit)) {
        	double new_value = this.mapping.get(unit).value() + value;
        	this.mapping.put(unit, new Price(new_value, unit.name()));        	
        } else {        	
        	this.mapping.put(unit, new Price(value, unit.name()));
        }
    }
}
