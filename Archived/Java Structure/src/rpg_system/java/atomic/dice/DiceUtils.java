package atomic.dice;

import java.util.*;

public abstract class DiceUtils 
{
	public static int roll(DiceElement dice) {
		return (int) Math.ceil(Math.random() * dice.max_possible());
	}
	
	public static int[] roll_all(Dice dice_bundle) {
		List<Integer> rolls = new ArrayList<Integer>();
		for(int i = 0; i < dice_bundle.amount(); i++) 
			rolls.add(roll(dice_bundle.element()));
		return rolls.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static int[] roll_all(DiceManager dice_manager) {
    	List<Integer> rolls = new ArrayList<Integer>();
        for (Dice dice_bundle : dice_manager.to_array(Dice.class)) {
        	for (int rolled_value : roll_all(dice_bundle)) {
        		rolls.add(rolled_value);        		
        	}
        }
        return rolls.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static int[] roll_all(Collection<Dice> dices) {
		DiceManager dice_manager = new DiceManager().gather(dices);
        return roll_all(dice_manager);
    }
	
	public static int[] roll_all_by_types(DiceManager dice_manager, Collection<DiceElement> dice_filter) {
    	List<Dice> filtered_bundles = new ArrayList<Dice>();
        for (Dice dice_bundle : dice_manager.to_array(Dice.class)) {
        	if (dice_filter.contains(dice_bundle.element())) {
        		filtered_bundles.add(dice_bundle);
        	}
        }
        return roll_all(filtered_bundles);
    }
	
	public static int sum(int[] values) {
		int sum = 0;
		for(int i : values)
			sum += i;
		return sum;
	}
}
