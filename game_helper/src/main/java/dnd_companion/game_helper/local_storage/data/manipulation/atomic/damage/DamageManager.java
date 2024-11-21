package dnd_companion.game_helper.local_storage.data.manipulation.atomic.damage;

import java.util.Arrays;
import java.util.Collection;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.AbstractManager;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.dice.Dice;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.dice.DiceManager;

public class DamageManager extends AbstractManager<Damage, DamageGroup, DamageManager>
{
    public DamageManager() {
        super();
    }
    public DamageManager(Collection<DamageGroup> damage_groups) {
        super(damage_groups);
    }
    public DamageManager(DamageManager damage_manager) {
        super(damage_manager);
    }
    
    @Override protected void remove_element(DamageGroup damage_group) {
    	Damage damage = damage_group.element();
        if (this.mapping.containsKey(damage)) {
            DamageGroup existing_group = this.mapping.get(damage);
            DiceManager new_dice_manager = existing_group.dices();
            new_dice_manager.remove(Arrays.asList(damage_group.dices().to_array(Dice.class)));
            
            if(!new_dice_manager.mapping().isEmpty()) {
            	this.mapping.put(damage, new DamageGroup(damage, new_dice_manager));
            } else {
            	this.mapping.remove(damage);
            }
        }
    }
    
    @Override protected void add_element(DamageGroup damage_group) {
    	Damage damage = damage_group.element();
    	DiceManager dices = damage_group.dices();
    	
    	if (this.mapping.containsKey(damage)) {
    		this.mapping.get(damage).dices().merge(Arrays.asList(dices));
    	} else {
    		this.mapping.put(damage, damage_group);
    	}
    }
	
}
