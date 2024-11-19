package dnd_companion.tool_kit.data_management;

public class ArmorData implements Data  
{
	public String collection() {return "armors";}
	private String name;
	private Weight weight;
	private Price price;
	private ArmorCategory category;
	private int base_armor_class;
	private int strength_requirement;
	private boolean stealth_disavantage;
	
	
	
	public ArmorData(
		String name, 
		Weight weight, 
		Price price, 
		ArmorCategory category, 
		int base_armor_class,
		int strength_requirement, 
		boolean stealth_disavantage
	) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.category = category;
		this.base_armor_class = base_armor_class;
		this.strength_requirement = strength_requirement;
		this.stealth_disavantage = stealth_disavantage;
	}

	public String name() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public ArmorCategory getCategory() {
		return category;
	}

	public void setCategory(ArmorCategory category) {
		this.category = category;
	}

	public int getBase_armor_class() {
		return base_armor_class;
	}

	public void setBase_armor_class(int base_armor_class) {
		this.base_armor_class = base_armor_class;
	}

	public int getStrength_requirement() {
		return strength_requirement;
	}

	public void setStrength_requirement(int strength_requirement) {
		this.strength_requirement = strength_requirement;
	}

	public boolean isStealth_disavantage() {
		return stealth_disavantage;
	}

	public void setStealth_disavantage(boolean stealth_disavantage) {
		this.stealth_disavantage = stealth_disavantage;
	}

	public enum ArmorCategory {
		NONE, SHIELD, LIGHT, MEDIUM, HEAVY
	}
}
