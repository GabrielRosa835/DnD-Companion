package app.domain.elements;

import app.domain.elements.components.*;
import app.domain.elements.entities.options.items.*;
import app.domain.elements.entities.options.system.*;
import app.domain.elements.variants.*;
import app.experimental.*;
import app.infrastructure.storage.mappings.options.items.*;
import lombok.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Builder (setterPrefix = "with", toBuilder = true)
public record Weapon(
		String name,
		String description,
		MeasureComponent price,
		MeasureComponent weight,
		Map<String, ItemTag> tags,
		Map<String, WeaponProperty> weaponProperties,
		WeaponCategory category,
		WeaponMastery mastery,
		WeaponType type,
		DamageComponent damage,
		AmmunitionType ammunitionType,
		WeaponRangeComponent range,
		Dice versatileDice
) implements DomainElement, IsItem {

	public static Weapon from (WeaponMapping entity) {
		var itemProperties = entity.itemProperties();
		var itemTags = itemProperties.tags().stream().
				collect(Collectors.toMap(ItemTag::name, Function.identity()));
		var weaponProperties = entity.weaponProperties().stream().
				collect(Collectors.toMap(WeaponProperty::name, Function.identity()));
		var range = new WeaponRangeComponent(
				new MeasureComponent(entity.normalRangeUnit(), entity.normalRangeValue()),
				new MeasureComponent(entity.longRangeUnit(), entity.longRangeValue())
		);
		var damage = new DamageComponent(entity.damageDices(), entity.damageType(), entity.damageModifier());

		return Weapon.builder()
				.withName(itemProperties.name())
				.withDescription(itemProperties.description())
				.withPrice(itemProperties.price())
				.withWeight(itemProperties.weight())
				.withTags(itemTags)
				.withWeaponProperties(weaponProperties)
				.withCategory(entity.category())
				.withMastery(entity.mastery())
				.withType(entity.type())
				.withDamage(damage)
				.withAmmunitionType(entity.ammunitionType())
				.withRange(range)
				.withVersatileDice(entity.versatileDice())
				.build();
	}

}
