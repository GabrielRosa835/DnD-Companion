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
@Setter (AccessLevel.PRIVATE)
@Entity
@Table (name = "opt_items")
public class Item implements DomainEntity, IsItem {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@Embedded
	MeasureComponent price;
	@Embedded
	MeasureComponent weight;

	@Singular
	@ManyToMany
	Set<ItemTag> tags;

	@Override public Item itemProperties() {
		return this;
	}
}