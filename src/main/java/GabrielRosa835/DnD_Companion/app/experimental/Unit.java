package app.experimental;

import app.infrastructure.storage.mappings.options.system.*;
import jakarta.persistence.*;
import lombok.*;

@Builder (setterPrefix = "with", toBuilder = true)
public record Unit(
		Short key,
		String name,
		String description,
		UnitType type,
		String singularForm,
		String abbreviation,
		double normalizingFactor
) implements Persisted<Short> {
	public static Unit from (UnitMapping entity) {
		return Unit.builder()
				.withKey(entity.id())
				.withName(entity.name())
				.withDescription(entity.description())
				.withType(UnitType.from(entity.type()))
				.withSingularForm(entity.singularForm())
				.withAbbreviation(entity.abbreviation())
				.withNormalizingFactor(entity.normalizingFactor())
				.build();
	}
	public UnitMapping toMap () {
		return new UnitMapping()
				.id(key)
				.name(name)
				.description(description)
				.type(type.toMap())
				.singularForm(singularForm)
				.abbreviation(abbreviation)
				.normalizingFactor((float) normalizingFactor);
	}
}
