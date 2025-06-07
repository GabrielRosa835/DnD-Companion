package app.experimental;

import app.infrastructure.storage.mappings.options.system.*;
import lombok.*;

@Builder (setterPrefix = "with", toBuilder = true)
public record UnitType(
		Short key,
		String name,
		String description
) implements Persisted<Short> {
	public static UnitType from (UnitTypeMapping entity) {
		return UnitType.builder()
				.withKey(entity.id())
				.withName(entity.name())
				.withDescription(entity.description())
				.build();
	}
	public UnitTypeMapping toMap () {
		return new UnitTypeMapping()
				.id(key)
				.name(name)
				.description(description);
	}
}
