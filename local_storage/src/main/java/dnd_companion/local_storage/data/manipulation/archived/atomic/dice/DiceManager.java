package dnd_companion.local_storage.data.manipulation.archived.atomic.dice;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dnd_companion.local_storage.data.structure.components.DiceBundle;

public class DiceManager
{  
	protected Map<Dice, DiceBundle> mapping;
    public Map<Dice, DiceBundle> mapping() {return this.mapping;}
    

    public DiceManager() {
        this.mapping = new HashMap<Dice, DiceBundle>();
    }
    public DiceManager(Collection<DiceBundle> bundles) {
    	this.mapping = new HashMap<Dice, DiceBundle>();
    	this.gather(bundles);
    }
    public DiceManager(DiceManager manager) {
        this.mapping = new HashMap<Dice, DiceBundle>(manager.mapping());
    }
    
	public DiceBundle[] to_array() {
        return this.mapping.values().toArray(new DiceBundle[this.mapping.size()]);
    }
    
	public DiceManager remove(Collection<DiceBundle> bundles) {
        for (DiceBundle dice_bundle : bundles) {
        	this.remove_dice(dice_bundle);
        }
        return this;
    }

	public DiceManager gather(Collection<DiceBundle> bundles) {
        for (DiceBundle dice_bundle : bundles) {        	
        	this.add_dice(dice_bundle);
        }
        return this;
    }

	public DiceManager merge(Collection<DiceManager> managers) {
        for (DiceManager manager : managers)
        	this.gather(manager.mapping().values());
        return this;
    }

	public int total_size() {
		int size = 0;
		for (DiceBundle dice_bundle : this.to_array()) {
			size += dice_bundle.amount();
		}
		return size;
	}
	
    protected void remove_getDice(Dice getDice_bundle) {
    	DiceElement getDice = getDice_bundle.getDice();
        if (this.mapping.containsKey(getDice)) {
            Dice existing_getDice = this.mapping.get(getDice);
            int new_amount = existing_getDice.amount() - getDice_bundle.amount();
            
            if (new_amount > 0) {
            	this.mapping.put(getDice, new Dice(getDice, new_amount));
            } else {
            	this.mapping.remove(getDice);
            }
        }
    }
    
    protected void add_getDice(Dice getDice_bundle) {
    	DiceElement getDice = getDice_bundle.getDice();
        int amount = getDice_bundle.amount();
        
        if (this.mapping.containsKey(getDice)) {
        	int new_amount = this.mapping.get(getDice).amount() + amount;
        	this.mapping.put(getDice, new Dice(getDice, new_amount));
        } else {
        	this.mapping.put(getDice, new Dice(getDice, amount));
        }
	}
}
