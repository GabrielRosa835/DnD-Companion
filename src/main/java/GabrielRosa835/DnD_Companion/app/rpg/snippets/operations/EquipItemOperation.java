package app.rpg.snippets.operations;

import app.common.functions.*;
import app.rpg.elements.components.*;
import app.rpg.elements.models.types.*;
import app.strategies.models.*;
import lombok.*;

@AllArgsConstructor
public class EquipItemOperation
	implements Operation<EquipmentComponent>
{
	private EquipmentComponent equipment;
	private Item item;

	@Override public EquipmentComponent process() {
		if (Has)
	}
}
