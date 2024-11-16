package main.description;

import java.util.*;

public class Alignment {
	private String morality;				// ACTIONS DONE
	private String order;					// RULES FOLLOWED
	private Map<String, String> tendency;	// COMBINATION OF BOTH
	
	public Alignment(
		String morality, 
		String order
	){
		this.morality = morality;
		this.order = order;
		this.tendency = new HashMap<String, String>();
		this.tendency.put("morality", morality);
		this.tendency.put("order", order);
	}
	
	public Alignment(
		Map<String, String> tendency
	){
		this.tendency = tendency;
		this.morality = tendency.get("morality");
		this.order = tendency.get("order");
	}

	public String get_morality() {return morality;}
	public void set_morality(String morality) {this.morality = morality;}

	public String get_order() {return order;}
	public void set_order(String order) {this.order = order;}

	public String[] get_tendency() {return tendency.values().toArray(new String[0]);}
	public void reset_tendency() {
		this.tendency.clear();
		this.tendency.put("morality", morality);
		this.tendency.put("order", order);
	}
}