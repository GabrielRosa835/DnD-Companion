package dnd_companion.archives.game_helper.actors.entities.items;

import java.util.Arrays;

import dnd_companion.entities.components.Price;
import dnd_companion.entities.components.WeaponDamage;
import dnd_companion.entities.components.WeaponRange;
import dnd_companion.entities.components.Weight;
import dnd_companion.game_helper.actors.components.items.ItemTagComponent;
import dnd_companion.game_helper.actors.components.items.weapons.WeaponCategoryComponent;
import dnd_companion.game_helper.actors.components.items.weapons.WeaponMasteryComponent;
import dnd_companion.game_helper.actors.components.items.weapons.WeaponPropertyComponent;
import dnd_companion.game_helper.actors.components.items.weapons.WeaponTypeComponent;
import dnd_companion.game_helper.actors.models.ItemComponent;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.items.weapons.WeaponData;
import dnd_companion.local_storage.tools.DataKey;

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
		double price_value, String price_unit,
		double weight_value, String weight_unit,
		String[] tags,
		String description,
		String type,
		String category,
		String mastery,
		String[] properties,
		double min_range_value, double max_range_value, String range_unit,
		String versatile_dice_type
	) {
		this.name = name;
		this.price = new Price(price_value, price_unit);
		this.weight = new Weight(weight_value, weight_unit);
		this.tags = Arrays.stream(tags)
				.map(ItemTagComponent::new)
				.toArray(ItemTagComponent[]::new);
		this.description = description;
		this.type = new WeaponTypeComponent(type);
		this.category = new WeaponCategoryComponent(category);
		this.mastery = new WeaponMasteryComponent(mastery);
		this.properties = Arrays.stream(properties)
				.map(WeaponPropertyComponent::new)
				.toArray(WeaponPropertyComponent[]::new);
		this.range = new WeaponRange(
				new Range(min_range_value, range_unit), 
				new Range(max_range_value, range_unit));
		this.
		
		
	}
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
