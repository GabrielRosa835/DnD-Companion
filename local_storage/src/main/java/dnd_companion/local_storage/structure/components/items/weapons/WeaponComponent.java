package dnd_companion.local_storage.structure.components.items.weapons;

import java.util.Arrays;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.components.ItemComponent;
import dnd_companion.local_storage.structure.components.items.tags.ItemTagComponent;
import dnd_companion.local_storage.structure.components.system.units.PriceComponent;
import dnd_companion.local_storage.structure.components.system.units.WeightComponent;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponData;

public class WeaponComponent implements ItemComponent
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

	public WeaponComponent(String weapon_name) {
		WeaponData data = (WeaponData) new DataHandler()
				.retrieve(new DataKey(new WeaponData().collection(), weapon_name, WeaponData.class))
				.result();
		this.name = data.name();
		this.price = new PriceComponent(data.price_value(), data.price_unit());
		this.weight = new WeightComponent(data.weight_value(), data.weight_unit());
		this.tags = Arrays.stream(data.tags())
				.map(ItemTagComponent::new)
				.toArray(ItemTagComponent[]::new);
		this.description = data.description();
		this.type = new WeaponTypeComponent(data.type());
		this.category = new WeaponCategoryComponent(data.category());
		this.mastery = new WeaponMasteryComponent(data.mastery());
		this.properties = Arrays.stream(data.properties())
				.map(WeaponPropertyComponent::new)
				.toArray(WeaponPropertyComponent[]::new);
		this.damage = null;
		this.range = new WeaponRange(data);
	}
}
