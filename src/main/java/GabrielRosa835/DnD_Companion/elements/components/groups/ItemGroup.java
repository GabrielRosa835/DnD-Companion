package elements.components.groups;

import elements.models.Item;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class ItemGroup implements
		Effect.Applicable<ItemGroup>
{
	private Item type;
	private int amount;

	@Override public ItemGroup applyEffect (Effect<ItemGroup> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.amount = result.amount;
		return this;
	}
}
