package dnd_companion.game_helper.local_storage.data_structure.options.dice;

import java.util.*;

public class DiceCollection
{  
	protected Map<Dice, DiceBundle> mapping;
    public Map<Dice, DiceBundle> mapping() {return this.mapping;}

    public DiceCollection() {
        this.mapping = new HashMap<Dice, DiceBundle>();
    }
    public DiceCollection(Collection<DiceBundle> bundles) {
    	this.mapping = new HashMap<Dice, DiceBundle>();
    	this.gather(bundles);
    }
    public DiceCollection(DiceCollection manager) {
        this.mapping = new HashMap<Dice, DiceBundle>(manager.mapping());
    }
    
	public DiceBundle[] to_array() {
        return this.mapping.values().toArray(new DiceBundle[this.mapping.size()]);
    }
    
	public DiceCollection remove(Collection<DiceBundle> bundles) {
        for (DiceBundle dice_bundle : bundles) {
        	this.remove_dice(dice_bundle);
        }
        return this;
    }

	public DiceCollection gather(Collection<DiceBundle> bundles) {
        for (DiceBundle dice_bundle : bundles) {        	
        	this.add_dice(dice_bundle);
        }
        return this;
    }

	public DiceCollection merge(Collection<DiceCollection> managers) {
        for (DiceCollection manager : managers)
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
	
    protected void remove_dice(DiceBundle dice_bundle) {
    	Dice dice = dice_bundle.dice();
        if (this.mapping.containsKey(dice)) {
        	DiceBundle existing_dice_bundle = this.mapping.get(dice);
            int new_amount = existing_dice_bundle.amount() - dice_bundle.amount();
            
            if (new_amount > 0) {
            	this.mapping.put(dice, new DiceBundle(new_amount, dice));
            } else {
            	this.mapping.remove(dice);
            }
        }
    }
    
    protected void add_dice(DiceBundle dice_bundle) {
    	Dice dice = dice_bundle.dice();
        int amount = dice_bundle.amount();
        
        if (this.mapping.containsKey(dice)) {
        	int new_amount = this.mapping.get(dice).amount() + amount;
        	this.mapping.put(dice, new DiceBundle(new_amount, dice));
        } else {
        	this.mapping.put(dice, new DiceBundle(amount, dice));
        }
	}
}
