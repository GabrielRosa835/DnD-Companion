package dnd_companion.local_storage.structure.components.items.armors;

import java.util.Arrays;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.ItemComponent;
import dnd_companion.local_storage.structure.components.items.tags.ItemTagComponent;
import dnd_companion.local_storage.structure.components.system.units.PriceComponent;
import dnd_companion.local_storage.structure.components.system.units.WeightComponent;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;

public class ArmorComponent implements ItemComponent
{
	private String name;
	@Override public String name() {return this.name;}
	
	private PriceComponent price;
	@Override public PriceComponent price() {return this.price;}
	
	private WeightComponent weight;
	@Override public WeightComponent weight() {return this.weight;}
	
	private ItemTagComponent[] tags;
	@Override public ItemTagComponent[] tags() {return this.tags;}
	
	private String description;
	@Override public String description() {return this.description;}
 	
	private ArmorCategoryComponent category;
	public ArmorCategoryComponent category() {return this.category;}
	
	private int armor_class;
	public int armor_class() {return this.armor_class;}
	
	private int strength_requirement;
	public int strength_requirement() {return this.strength_requirement;}
	
	private boolean stealth_disadvantage;
	public boolean stealth_disadvantage() {return this.stealth_disadvantage;}

	public ArmorComponent(String name) {
		ArmorData data = (ArmorData) new DataHandler()
				.retrieve(new DataKey(new ArmorData().collection(), name, ArmorData.class))
				.result();
		this.name = data.name();
		this.price = new PriceComponent(data.price_value(), data.price_unit());
		this.weight = new WeightComponent(data.weight_value(), data.weight_unit());
		this.tags = Arrays.stream(data.tags())
				.map(ItemTagComponent::new)
				.toArray(ItemTagComponent[]::new);
		this.description = data.description();
		this.category = new ArmorCategoryComponent(data.category());
		this.armor_class = data.armor_class();
		this.strength_requirement = data.strength_requirement();
		this.stealth_disadvantage = data.stealth_disadvantage();
	}
}
