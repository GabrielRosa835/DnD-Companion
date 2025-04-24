package app.rpg.elements.components;

import app.rpg.elements.models.Component;
import app.rpg.elements.options.UnitOption;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor(staticName = "create")
@Accessors(fluent = true)
@ToString
@Getter
public class MeasureComponent
		implements Component<MeasureComponent> {
	private UnitOption unitOption;
	private double value;

	@Override
	public void update(MeasureComponent clone) {
		this.unitOption = clone.unitOption;
		this.value = clone.value;
	}
}
