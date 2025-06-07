package app.domain.elements.components;

import app.domain.elements.entities.options.items.*;
import app.experimental.*;
import jakarta.persistence.*;

import java.util.*;

@Embeddable
public record CharacterEquipmentComponent(
		@ManyToOne
		ArmorM currentArmor,

		@ElementCollection (fetch = FetchType.LAZY)
		List<MeasureComponent> wealth,

		@ElementCollection (fetch = FetchType.LAZY)
		List<ItemAmountComponent> inventory,

		@OneToMany (fetch = FetchType.LAZY)
		Set<Item> attunedMagicItems
) {}
