package GabrielRosa835.entities;

import GabrielRosa835.*;
import GabrielRosa835.components.*;
import GabrielRosa835.models.*;
import GabrielRosa835.models.types.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED) //Needed for SpringJPA
@Builder
@ToString
@Getter
public class Armor implements Entity, Replicable
{
	private String name;

	private Measure.Price price;

	private Measure.Weight weight;

	private String description;

	private Category category;

	private List<Item.Tag> tags;
	public Item.Tag[] getTags() {
		return tags.toArray(Item.Tag[]::new);
	}

	private int armorClass;

	private int strengthRequirement;

	private boolean stealthDisadvantage;

 // ==================================================================================

	public enum Category {
		UNARMORED, LIGHT, MEDIUM, HEAVY
	}

	@RequiredArgsConstructor
	public enum Data implements GabrielRosa835.models.Data<Armor> {
		CHAIN_MAIL(null);

		private final Armor data;

		public Armor use() {
			return (Armor) this.data.replicate();
		}
	}

	public interface Effect extends GabrielRosa835.Effect {
		String changeName();
		Measure.Price changePrice();
		Measure.Weight changeWeight();
		String changeDescription();
		Category changeCategory();
		List<Item.Tag> changeTags();
		int changeArmorClass();
		int changeStrengthRequirement();
		boolean changeStealthDisadvantage();
	}
}