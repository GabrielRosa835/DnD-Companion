package dnd_companion.actors.entities.armor;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.data.ChainMail;
import dnd_companion.actors.entities.armor.data.LeatherArmor;
import dnd_companion.actors.entities.armor.data.ScaleMail;
import dnd_companion.actors.entities.armor.data.Unarmored;
import dnd_companion.actors.entities.item.Item;
import dnd_companion.actors.entities.system.unit.currency.data.NormalCurrencyUnit;
import dnd_companion.actors.entities.system.unit.weight.data.NormalWeightUnit;
import dnd_companion.actors.models.IData;
import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityBuilder;
import dnd_companion.common.BaseCollections;
import dnd_companion.common.ToolBox;
import dnd_companion.effects.Effectable;
import dnd_companion.effects.IEffect;

public class Armor implements IEntity, Effectable, Item
{
 // ================================================================================
	private String name;
	@JsonProperty @Override public String name() {return name;}
	
	private Price price;
	@Override public Price price() {return price;}
	@JsonProperty private double price_value() {return price.value();}
	@JsonProperty private String price_unit() {return price.unit().name();}
	
	private Weight weight;
	@Override public Weight weight() {return weight;}
	@JsonProperty private double weight_value() {return weight.value();}
	@JsonProperty private String weight_unit() {return weight.unit().name();}
	
	private Item.Tags[] tags;
	@JsonProperty @Override public Item.Tags[] tags() {return tags;}
	
	private String description;
	@JsonProperty @Override public String description() {return description;}
	
	private Category category;
	@JsonProperty public Category category() {return this.category;}
	
	private int armorClass;
	@JsonProperty public int armorClass() {return this.armorClass;}
	
	private int strengthRequirement;
	@JsonProperty public int strengthRequirement() {return this.strengthRequirement;}
	
	private boolean stealthDisadvantage;
	@JsonProperty public boolean stealthDisadvantage() {return this.stealthDisadvantage;}

	Armor(
		String name,
		Price price,
		Weight weight,
		Item.Tags[] tags,
		String description,
		Category category,
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
	
	protected Armor(Armor entity) {
		this(
			entity.name,
			entity.price.clone(),
			entity.weight.clone(),
			entity.tags,
			entity.description,
			entity.category,
			entity.armorClass,
			entity.strengthRequirement,
			entity.stealthDisadvantage
		);
	}
	@Override public Armor clone() {
		return new Armor(this);
	}
	
	@Override public String toString() {
		return String.format("Armor[name=%s, price=%s, weight=%s, tags=%s, description=%s]",
				name, price.toString(), weight.toString(), Arrays.toString(tags), description);
	}
	
	@Override public Armor applyEffect(IEffect e) {
		Effect effect = (Effect) e;
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
 //	================================================================================	
	public static BaseCollections collection() {
		return BaseCollections.ARMORS;
	}
	public static String path(String armorName) {
		return collection().path() + File.separator + ToolBox.toFileName(armorName);
	}
	public String path() {
		return Armor.path(this.name);
	}
	public static Builder builder() {
		return new Builder();
	}
//	public static Armor retrieve(String entity_name) {
//		return (Armor) DataHandler.retrieve(this, entity_name);
//	}
 //	================================================================================
	public static enum Category 
	{
		HEAVY, MEDIUM, LIGHT, UNARMORED;
	}
 //	================================================================================	
	public interface Effect extends IEffect 
	{
		public String changeName();
		public Price changePrice();
		public Weight changeWeight();
		public Item.Tags[] changeTags();
		public String changeDescription();
		public Category changeCategory();
		public int changeArmorClass();
		public int changeStrengthRequirement();
		public boolean changeStealthDisadvantage();
	}
 //	================================================================================
	public enum Data implements IData
	{
		CHAIN_MAIL(new ChainMail()), 
		LEATHER_ARMOR(new LeatherArmor()), 
		SCALE_MAIL(new ScaleMail()), 
		UNARMORED(new Unarmored());
		
		private Armor entity;
		private Data(Armor entity) {
			this.entity = entity;
		}
		@Override public Armor use() {
			return entity.clone();
		}
	}
 //	================================================================================
	public static class Builder implements IEntityBuilder 
	{
		private String name = "No name";
		private Price price = new Price(0, new NormalCurrencyUnit());
		private Weight weight = new Weight(0, new NormalWeightUnit());
		private Item.Tags[] tags = new Item.Tags[] {};
		private String description = "No description";
		private Category category = Category.UNARMORED;
		private int armor_class = 10;
		private int strength_requirement = 0;
		private boolean stealth_disadvantage = false;

		private Builder() {}

		@Override public Armor build() {
			return new Armor(
				name,
				price,
				weight,
				tags,
				description,
				category,
				armor_class,
				strength_requirement,
				stealth_disadvantage
			);
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder price(Price price) {
			this.price = price;
			return this;
		}
		public Builder weight(Weight weight) {
			this.weight = weight;
			return this;
		}
		public Builder tags(Item.Tags... tags) {
			this.tags = tags;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Builder category(Category category) {
			this.category = category;
			return this;
		}
		public Builder armor_class(int armor_class) {
			this.armor_class = armor_class;
			return this;
		}
		public Builder strength_requirement(int strength_requirement) {
			this.strength_requirement = strength_requirement;
			return this;
		}
		public Builder stealth_disadvantage(boolean stealth_disadvantage) {
			this.stealth_disadvantage = stealth_disadvantage;
			return this;
		}
	}
 //	================================================================================
}
