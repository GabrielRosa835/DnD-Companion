package app.domain.elements.options.items;

import app.domain.elements.components.*;
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
@Table (name = "opt_armors")
public class Armor implements DomainEntity, IsItem
{
	@ManyToOne
	Item itemProperties;

	@ManyToOne
	ArmorCategory category;

	boolean stealthDisadvantage;
	int strengthRequirement;
	int baseArmorClass;

	@Id
	@Column (name = "name")
	@Override public String name() {
		return itemProperties.name();
	}
}