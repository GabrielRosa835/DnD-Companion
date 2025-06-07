package app.infrastructure.storage.mappings.options.items;

import app.infrastructure.storage.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter
@Entity
@Table (name = "opt_armors")
public class ArmorMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@ManyToOne
	ItemMapping itemProperties;

	@ManyToOne
	ArmorCategoryMapping category;

	boolean stealthDisadvantage;
	short strengthRequirement;
	short baseArmorClass;
}