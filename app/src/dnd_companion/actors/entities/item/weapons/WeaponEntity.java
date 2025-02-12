package dnd_companion.actors.entities.item.weapons;

import java.util.Arrays;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.components.weapon.WeaponDamage;
import dnd_companion.actors.components.weapon.WeaponRange;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;
import dnd_companion.actors.entities.item.weapons.category.WeaponCategoryEntity;
import dnd_companion.actors.entities.item.weapons.mastery.WeaponMasteryEntity;
import dnd_companion.actors.entities.item.weapons.properties.WeaponPropertyEntity;
import dnd_companion.actors.entities.item.weapons.type.WeaponTypeEntity;
import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.types.Item;
import dnd_companion.effects.IEffect;
import dnd_companion.effects.Effectable;

public class WeaponEntity implements IEntity, Item, Effectable
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTagEntity[] tags;
	private String description;
	private WeaponTypeEntity type;
	private WeaponCategoryEntity category;
	private WeaponMasteryEntity mastery;
	private WeaponPropertyEntity[] properties;
	private WeaponDamage damage;
	private WeaponRange range;

	@Override public String name() {return this.name;}
	@Override public Price price() {return this.price;}
	@Override public Weight weight() {return this.weight;}
	@Override public ItemTagEntity[] tags() {return this.tags;}
	@Override public String description() {return this.description;}
	public WeaponTypeEntity type() {return this.type;}
	public WeaponCategoryEntity category() {return this.category;}
	public WeaponMasteryEntity mastery() {return this.mastery;}
	public WeaponPropertyEntity[] properties() {return this.properties;}
	public WeaponDamage damage() {return this.damage;}
	public WeaponRange range() {return this.range;}

	WeaponEntity(
		String name,
		Price price,
		Weight weight,
		ItemTagEntity[] tags,
		String description,
		WeaponTypeEntity type,
		WeaponCategoryEntity category,
		WeaponMasteryEntity mastery,
		WeaponPropertyEntity[] properties,
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
	private WeaponEntity(WeaponEntity entity) {
		this(
			entity.name,
			entity.price,
			entity.weight,
			entity.tags,
			entity.description,
			entity.type,
			entity.category,
			entity.mastery,
			entity.properties,
			entity.damage,
			entity.range
		);
	}

	@Override public WeaponEntity clone() {
		return new WeaponEntity(this);
	}
	@Override public String toString() {
		return String.format("Weapon[name=%s, price=%s, weight=%s, tags=%s, description=%s, type=%s, "
				+ "category=%s, mastery=%s, properties=%s, damage=%s, range=%s]",
				name, price.toString(), weight.toString(), Arrays.toString(tags), description, type.toString(),
				category.toString(), mastery.toString(), Arrays.toString(properties), damage.toString(), range.toString());
	}
	@Override public WeaponEntity applyEffect(IEffect e) {
		InterEffect effect = (InterEffect) e;
		effect.loadObject(this);
		this.name = effect.changeName();
		this.price = effect.changePrice();
		this.weight = effect.changeWeight();
		this.tags = effect.changeTags();
		this.description = effect.changeDescription();
		this.type = effect.changeType();
		this.category = effect.changeCategory();
		this.mastery = effect.changeMastery();
		this.properties = effect.changeProperties();
		this.damage = effect.changeDamage();
		this.range = effect.changeRange();
		return this;
	}
	
	public interface InterEffect extends IEffect {
		public String changeName();
		public Price changePrice();
		public Weight changeWeight();
		public ItemTagEntity[] changeTags();
		public String changeDescription();
		public WeaponTypeEntity changeType();
		public WeaponCategoryEntity changeCategory();
		public WeaponMasteryEntity changeMastery();
		public WeaponPropertyEntity[] changeProperties();
		public WeaponDamage changeDamage();
		public WeaponRange changeRange();
	}
}
