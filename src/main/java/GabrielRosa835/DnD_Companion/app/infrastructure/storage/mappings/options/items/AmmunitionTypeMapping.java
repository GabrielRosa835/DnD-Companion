package app.infrastructure.storage.mappings.options.items;

import app.infrastructure.storage.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Getter
@Setter
@Entity
@Table (name = "opt_ammunition_types")
public class AmmunitionTypeMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@ManyToOne
	ItemMapping itemProperties;

	@ManyToMany
	List<WeaponMapping> allowedWeaponEntities = new ArrayList<>();
}