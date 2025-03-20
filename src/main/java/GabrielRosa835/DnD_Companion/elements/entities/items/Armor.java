package elements.entities.items;

import common.*;
import elements.entities.system.Measure;
import elements.models.Item;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.jpa.repository.JpaRepository;
import tactics.*;

@Entity
@Table

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