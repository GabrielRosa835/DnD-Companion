package app.infrastructure.storage.mappings.options.items;

import app.infrastructure.storage.*;
import app.infrastructure.storage.mappings.options.system.*;
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
@Table (name = "opt_items")
public class ItemMapping implements Persistent<Integer> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;

	@Column (unique = true)
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	UnitMapping priceUnit;
	float priceValue;

	@ManyToOne
	UnitMapping weightUnit;
	float weightValue;

	@ManyToMany
	List<ItemTagMapping> tags = new ArrayList<>();
}