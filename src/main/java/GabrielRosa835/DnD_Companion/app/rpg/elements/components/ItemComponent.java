package app.rpg.elements.components;

import app.rpg.elements.models.Component;
import app.rpg.elements.models.types.Item;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor(staticName = "create")
@Accessors(fluent = true)
@ToString
@Getter
public class ItemComponent
		implements Component<ItemComponent> {
	private Item type;
	private int amount;

	@Override
	public void update(ItemComponent clone) {
		this.type = clone.type;
		this.amount = clone.amount;
	}
}
