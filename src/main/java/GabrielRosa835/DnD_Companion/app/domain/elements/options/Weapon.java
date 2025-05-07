package app.domain.elements.options;

import app.domain.elements.components.*;
import app.domain.elements.models.*;
import app.domain.elements.models.types.*;
import lombok.*;

import java.util.*;

@Builder(setterPrefix = "with")
public record Weapon(
		String ID,
		String name,
		Set<ItemTag> tags,
		String description,
		MeasureComponent weight,
		MeasureComponent price,

		Set<WeaponProperty> properties,
		WeaponCategory category,
		WeaponMastery mastery,
		WeaponType type,
		DamageComponent damage,

		AmmunitionType ammunitionType,
		MeasureComponent normalRange,
		MeasureComponent longRange,
		Dice versatileDice
) implements Option, Item {
//	boolean isFinesse(MongoDBService database) {
//		var FINESSE_PROPERTY = database
//				.retrieve(DBCollection.of(WeaponProperty.class), "Finesse")
//				.stream().findFirst();
//		if(FINESSE_PROPERTY.isPresent()) {
//			return this.properties().contains(FINESSE_PROPERTY.get());
//		} else {
//			throw CoreElementNotFoundException.of("Finesse");
//		}
//	}
}
