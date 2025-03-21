package GabrielRosa835.dnd_companion.app.elements.entities.items;

import GabrielRosa835.dnd_companion.app.common.*;
import GabrielRosa835.dnd_companion.app.elements.entities.system.*;
import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.jpa.repository.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class Armor implements
		Effect.Applicable<Armor>,
		Replicable,
		Item
{
	private boolean stealthDisadvantage;
	private int strengthRequirement;
	private ArmorCategory category;
	private int baseArmorClass;
	private String description;
	private ItemTag[] tags;
	private Measure weight;
	private Measure price;
	private String name;

	@Override
	public Armor applyEffect(Effect<Armor> effect) {
		var result = effect.applyTo(this);
		this.stealthDisadvantage = result.stealthDisadvantage;
		this.strengthRequirement = result.strengthRequirement;
		this.baseArmorClass = result.baseArmorClass;
		this.description = result.description;
		this.category = result.category;
		this.weight = result.weight;
		this.price = result.price;
		this.tags = result.tags;
		this.name = result.name;
		return this;
	}

	public interface Repository extends JpaRepository<Armor, Integer> {}
}