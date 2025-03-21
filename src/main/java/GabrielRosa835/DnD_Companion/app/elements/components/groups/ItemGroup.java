package GabrielRosa835.dnd_companion.app.elements.components.groups;


import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(fluent = true)
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
