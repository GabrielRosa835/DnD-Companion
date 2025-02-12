package dnd_companion.actors.entities.armor;

import java.util.Arrays;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;
import dnd_companion.actors.models.IEntity;
import dnd_companion.effects.Effectable;
import dnd_companion.effects.IEffect;

public class ArmorEntity implements IEntity, Effectable
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTagEntity[] tags;
	private String description;
	private ArmorCategoryEntity category;
	private int armorClass;
	private int strengthRequirement;
	private boolean stealthDisadvantage;

	@Override public String name() {return name;}
	public Price price() {return price;}
	public Weight weight() {return weight;}
	public ItemTagEntity[] tags() {return tags;}
	public String description() {return description;}
	public ArmorCategoryEntity category() {return this.category;}
	public int armorClass() {return this.armorClass;}
	public int strengthRequirement() {return this.strengthRequirement;}
	public boolean stealthDisadvantage() {return this.stealthDisadvantage;}

	ArmorEntity(
		String name,
		Price price,
		Weight weight,
		ItemTagEntity[] tags,
		String description,
		ArmorCategoryEntity category,
		int armorClass,
		int strengthRequirement,
		boolean stealthDisadvantage
	) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
		this.category = category;
		this.armorClass = armorClass;
		this.strengthRequirement = strengthRequirement;
		this.stealthDisadvantage = stealthDisadvantage;
	}
	
	protected ArmorEntity(ArmorEntity entity) {
		this(
			entity.name,
			entity.price.clone(),
			entity.weight.clone(),
			Arrays.stream(entity.tags)
				.map(t -> t.clone())
				.toArray(ItemTagEntity[]::new),
			entity.description,
			entity.category.clone(),
			entity.armorClass,
			entity.strengthRequirement,
			entity.stealthDisadvantage
		);
	}
	@Override public ArmorEntity clone() {
		return new ArmorEntity(this);
	}
	
	@Override public String toString() {
		return String.format("Armor[name=%s, price=%s, weight=%s, tags=%s, description=%s]",
				name, price.toString(), weight.toString(), Arrays.toString(tags), description);
	}
	
	@Override public ArmorEntity applyEffect(IEffect e) {
		ArmorEffect effect = (ArmorEffect) e;
		effect.loadObject(this);
		this.name = effect.changeName();
		this.price = effect.changePrice();
		this.weight = effect.changeWeight();
		this.tags = effect.changeTags();
		this.description = effect.changeDescription();
		this.category = effect.changeCategory();
		this.armorClass = effect.changeArmorClass();
		this.strengthRequirement = effect.changeStrengthRequirement();
		this.stealthDisadvantage = effect.changeStealthDisadvantage();
		return this;
	}
}
