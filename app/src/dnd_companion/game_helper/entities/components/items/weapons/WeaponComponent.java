package dnd_companion.game_helper.entities.components.items.weapons;

import java.util.Arrays;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.components.items.tags.ItemTagComponent;
import dnd_companion.game_helper.entities.data.items.weapons.WeaponData;
import dnd_companion.game_helper.entities.elements.WeaponDamage;
import dnd_companion.game_helper.entities.elements.WeaponRange;
import dnd_companion.game_helper.entities.elements.system.units.Price;
import dnd_companion.game_helper.entities.elements.system.units.Weight;
import dnd_companion.local_storage.structure.models.components.item.ItemComponent;

public class WeaponComponent implements ItemComponent
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
	
	private WeaponTypeComponent type;
	public WeaponTypeComponent type() {return this.type;}
	
	private WeaponCategoryComponent category;
	public WeaponCategoryComponent category() {return this.category;}
	
	private WeaponMasteryComponent mastery;
	public WeaponMasteryComponent mastery() {return this.mastery;}
	
	private WeaponPropertyComponent[] properties;
	public WeaponPropertyComponent[] properties() {return this.properties;}
	
	private WeaponDamage damage;
	public WeaponDamage damage() {return this.damage;}
	
	private WeaponRange range;
	public WeaponRange range() {return this.range;}

	private WeaponComponent(
		String name, 
		Price price, 
		Weight weight, 
		ItemTagComponent[] tags,
		String description, 
		WeaponTypeComponent type, 
		WeaponCategoryComponent category,
		WeaponMasteryComponent mastery, 
		WeaponPropertyComponent[] properties, 
		WeaponDamage damage,
		WeaponRange range
	) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
		this.type = type;
		this.category = category;
		this.mastery = mastery;
		this.properties = properties;
		this.damage = damage;
		this.range = range;
	}
	public WeaponComponent() {
		this(null, null, null, null, null, null, null, null, null, null, null);
	}
	public WeaponComponent(WeaponData data) {
		this(
			data.name(),
			new Price(data.price_value(), data.price_unit()),
			new Weight(data.weight_value(), data.weight_unit()),
			Arrays.stream(data.tags())
					.map(ItemTagComponent::new)
					.toArray(ItemTagComponent[]::new),
			data.description(),
			new WeaponTypeComponent(data.type()),
			new WeaponCategoryComponent(data.category()),
			new WeaponMasteryComponent(data.mastery()),
			Arrays.stream(data.properties())
					.map(WeaponPropertyComponent::new)
					.toArray(WeaponPropertyComponent[]::new),
			null,
			new WeaponRange(data)
		);
	}
	public WeaponComponent(String name) {
		this(new WeaponComponent().retrieve(name));
	}
	
	@Override public WeaponData retrieve(String name) {
		return (WeaponData) new DataHandler()
				.retrieve(new DataKey(new WeaponData().collection(), name, WeaponData.class))
				.result();
	}
	@Override public WeaponComponent copy() {
		if (this.name == null) {
			return new WeaponComponent();
		} else {			
			return new WeaponComponent(this.name);
		}
	}
}
