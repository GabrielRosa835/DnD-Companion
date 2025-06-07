package app.infrastructure.storage.mappings.options.items;

import app.experimental.*;
import app.infrastructure.storage.*;
import app.infrastructure.storage.mappings.options.system.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter
@Entity
@Table (name = "opt_weapons")
public class WeaponMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@ManyToOne (fetch = FetchType.LAZY)
	ItemMapping itemProperties;

	@ManyToMany (fetch = FetchType.LAZY)
	List<WeaponPropertyMapping> weaponProperties;

	@ManyToOne (fetch = FetchType.LAZY)
	WeaponCategoryMapping category;

	@ManyToOne (fetch = FetchType.LAZY)
	WeaponMasteryMapping mastery;

	@ManyToOne (fetch = FetchType.LAZY)
	WeaponTypeMapping type;

	@ElementCollection
	List<DiceAmount> damageDices;

	@ManyToOne (fetch = FetchType.LAZY)
	DamageTypeMapping damageType;

	short damageModifier;

	@ManyToOne (fetch = FetchType.LAZY)
	AmmunitionTypeMapping ammunitionType;

	@ManyToOne (fetch = FetchType.LAZY)
	UnitMapping normalRangeUnit;
	float normalRangeValue;

	@ManyToOne (fetch = FetchType.LAZY)
	UnitMapping longRangeUnit;
	float longRangeValue;

	@ManyToOne (fetch = FetchType.LAZY)
	DiceMapping versatileDice;

	@Embeddable
	private record DiceAmount(
			@ManyToOne
			DiceMapping dice,
			short amount
	) {}
}