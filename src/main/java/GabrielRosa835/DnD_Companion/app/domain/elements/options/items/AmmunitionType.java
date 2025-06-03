package app.domain.elements.options.items;

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
@Table (name = "opt_ammunition_types")
public class AmmunitionType implements DomainEntity, IsItem {

	@ManyToOne
	Item itemProperties;

	@ManyToMany
	@Singular ("weapon")
	List<Weapon> allowedWeapons;

	@Id
	@Column (name = "name")
	@Override public String name () {
		return itemProperties.name();
	}
}