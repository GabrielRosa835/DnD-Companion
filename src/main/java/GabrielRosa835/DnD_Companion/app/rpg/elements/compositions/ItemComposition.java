package app.rpg.elements.compositions;

import app.rpg.elements.components.ItemComponent;
import app.rpg.models.Composition;
import app.rpg.elements.options.types.Item;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (staticName = "empty")
@Accessors (fluent = true)
@Builder (setterPrefix = "with")
@Getter
public class ItemComposition // "Belongings"
		implements Composition<ItemComposition>
{
	@Singular("item")
	private Map<Item, ItemComponent> content = new HashMap<>();

	@Override public void update (ItemComposition clone) {
		this.content.clear();
		this.content.putAll(clone.content);
	}
}
