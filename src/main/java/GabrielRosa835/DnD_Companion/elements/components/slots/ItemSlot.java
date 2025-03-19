package elements.components.slots;

import elements.models.types.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter
public class ItemSlot implements
		Effect.Applicable<ItemSlot>
{
	private Item type;
	private int amount;

	@Override
	public ItemSlot applyEffect (Effect<ItemSlot> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.amount = result.amount;
		return this;
	}
}
