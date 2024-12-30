package dnd_companion.game_helper.entities.components.items.armors;

import java.util.Arrays;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.components.items.tags.ItemTagComponent;
import dnd_companion.game_helper.entities.data.items.armors.ArmorData;
import dnd_companion.game_helper.entities.elements.system.units.Price;
import dnd_companion.game_helper.entities.elements.system.units.Weight;
import dnd_companion.local_storage.structure.models.components.item.ItemComponent;

public class ArmorComponent implements ItemComponent
{
	private String name;
	@Override public String name() {return this.name;}
	
	private Price price;
	@Override public Price price() {return this.price;}
	
	private Weight weight;
	@Override public Weight weight() {return this.weight;}
	
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
		this.price = new Price(data.price_value(), data.price_unit());
		this.weight = new Weight(data.weight_value(), data.weight_unit());
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
