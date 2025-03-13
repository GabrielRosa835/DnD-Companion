package elements.entities.options;

import common.*;
import elements.components.*;
import elements.models.types.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
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
}