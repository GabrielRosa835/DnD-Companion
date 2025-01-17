package dnd_companion.archives.game_helper.actors.entities.items.armors;

import java.util.Arrays;

import dnd_companion.archives.game_helper.actors.entities.items.ItemTagEntity;
import dnd_companion.archives.game_helper.actors.models.ItemComponent;
import dnd_companion.archives.local_storage.handling.DataHandler;
import dnd_companion.archives.local_storage.structure.items.armors.ArmorData;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.entities.components.Price;
import dnd_companion.entities.components.Weight;

public class ArmorComponent implements ItemComponent
{
	private String name;
	@Override public String name() {return this.name;}
	
	private Price price;
	@Override public Price price() {return this.price;}
	
	private Weight weight;
	@Override public Weight weight() {return this.weight;}
	
	private ItemTagEntity[] tags;
	@Override public ItemTagEntity[] tags() {return this.tags;}
	
	private String description;
	@Override public String description() {return this.description;}
 	
	private ArmorCategoryEntity category;
	public ArmorCategoryEntity category() {return this.category;}
	
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
				.map(ItemTagEntity::new)
				.toArray(ItemTagEntity[]::new);
		this.description = data.description();
		this.category = new ArmorCategoryEntity(data.category());
		this.armor_class = data.armor_class();
		this.strength_requirement = data.strength_requirement();
		this.stealth_disadvantage = data.stealth_disadvantage();
	}
}
