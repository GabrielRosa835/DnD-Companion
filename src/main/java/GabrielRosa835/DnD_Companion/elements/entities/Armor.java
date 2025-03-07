package elements.entities;

import GabrielRosa835.components.*;
import GabrielRosa835.models.*;
import GabrielRosa835.models.types.*;
import common.*;
import elements.components.*;
import elements.models.*;
import elements.models.types.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED) //Needed for SpringJPA
@Builder
@ToString
@Getter
@Accessors(fluent = true)
public class Armor implements
		Item, Entity, Replicable, Effect.Applicable, Action.Applicable
{
	private String name;
	private Measure.Price price;
	private Measure.Weight weight;
	private String description;
	private Category category;
	private List<Item.Tag> tags;
	private int baseArmorClass;
	private int strengthRequirement;
	private boolean stealthDisadvantage;

// ==================================================================================
	
	public Item.Tag[] tags() {
		return tags.toArray(Item.Tag[]::new);
	}

	public Armor actWith(Action action, tactics.Effect.Applicable... targets) {
		action.setSource(this).setTargets(targets).execute();
		return this;
	}
	
	public Armor applyEffect(Effect effect) {
		Effect e = (Effect) effect.loadElement(this).execute();
		this.name = e.changeName();
		this.price = e.changePrice();
		this.weight = e.changeWeight();
		this.description = e.changeDescription();
		this.category = e.changeCategory();
		this.tags = e.changeTags();
		this.baseArmorClass = e.changeBaseArmorClass();
		this.strengthRequirement = e.changeStrengthRequirement();
		this.stealthDisadvantage = e.changeStealthDisadvantage();
		return this;
	}

// ==================================================================================

	public enum Category {
		UNARMORED, LIGHT, MEDIUM, HEAVY
	}

	@RequiredArgsConstructor
	public enum Data implements elements.models.Data<Armor> {
		CHAIN_MAIL(null);

		private final Armor data;

		public Armor use() {
			return (Armor) this.data.replicate();
		}
	}
	
	public interface Effect extends Item.Effect {
		@Override String changeName();
		@Override Measure.Price changePrice();
		@Override Measure.Weight changeWeight();
		@Override String changeDescription();
		@Override List<Item.Tag> changeTags();
		Category changeCategory();
		int changeBaseArmorClass();
		int changeStrengthRequirement();
		boolean changeStealthDisadvantage();
	}
}