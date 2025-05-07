package app.domain.elements.components;

import app.domain.elements.options.DamageType;
import app.domain.elements.options.Dice;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@ToString
@Builder(setterPrefix = "with")
@Getter
public class DamageComponent {
	private List<Dice> dice;
	private DamageType type;
	private int modifier;
}
