package app.domain.elements.options.items;

import app.domain.elements.components.*;
import app.domain.elements.options.system.*;
import app.domain.elements.variants.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor (staticName = "create")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Builder (setterPrefix = "with")
@Getter
@Entity
@Table (name = "opt_weapons")
public class Weapon implements DomainEntity, IsItem {

	@ManyToOne
	Item itemProperties;

	@Singular("property")
	@ManyToMany
	Set<WeaponProperty> weaponProperties;

	@ManyToOne
	WeaponCategory category;

	@ManyToOne
	WeaponMastery mastery;

	@ManyToOne
	WeaponType type;

	@Embedded
	DamageComponent damage;

	@ManyToOne
	AmmunitionType ammunitionType;

	@Embedded
	MeasureComponent normalRange;

	@Embedded
	MeasureComponent longRange;

	@ManyToOne
	Dice versatileDice;

	@Override public String name() {
		return itemProperties.name();
	}
}