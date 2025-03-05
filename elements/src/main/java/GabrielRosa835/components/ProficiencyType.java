package GabrielRosa835.components;

import lombok.*;
import lombok.experimental.*;

@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public enum ProficiencyType {
	NONE(0), HALF(0.5), NORMAL(1), EXPERTISE(2);
	private final double multiplier;
}
