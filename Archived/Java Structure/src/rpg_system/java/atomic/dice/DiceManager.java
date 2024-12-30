package atomic.dice;

import java.util.Collection;

import atomic.GroupManager;

public class DiceManager extends GroupManager<DiceElement, Dice, DiceManager> 
{  
    public DiceManager() {
        super();
    }
    public DiceManager(Collection<Dice> dice_bundles) {
    	super(dice_bundles);
    }
    public DiceManager(DiceManager dice_manager) {
    	super(dice_manager);
    }

	public int total_size() {
		int size = 0;
		for (Dice dice_bundle : this.to_array(Dice.class)) {
			size += dice_bundle.amount();
		}
		return size;
	}
	
    @Override protected void remove_element(Dice dice_bundle) {
    	DiceElement dice = dice_bundle.element();
        if (this.mapping.containsKey(dice)) {
            Dice existing_dice = this.mapping.get(dice);
            int new_amount = existing_dice.amount() - dice_bundle.amount();
            
            if (new_amount > 0) {
            	this.mapping.put(dice, new Dice(dice, new_amount));
            } else {
            	this.mapping.remove(dice);
            }
        }
    }
    
    @Override protected void add_element(Dice dice_bundle) {
    	DiceElement dice = dice_bundle.element();
        int amount = dice_bundle.amount();
        
        if (this.mapping.containsKey(dice)) {
        	int new_amount = this.mapping.get(dice).amount() + amount;
        	this.mapping.put(dice, new Dice(dice, new_amount));
        } else {
        	this.mapping.put(dice, new Dice(dice, amount));
        }
	}
}
