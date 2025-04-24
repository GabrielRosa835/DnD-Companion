package app.rpg.elements.compositions;

import app.rpg.elements.components.MeasureComponent;
import app.rpg.elements.models.Composition;
import app.elements.options.*;
import app.rpg.elements.options.*;
import app.rpg.elements.options.dices.*;
import app.rpg.elements.options.weaponProperties.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(staticName = "empty")
@Accessors(fluent = true)
@Builder(setterPrefix = "with")
@Getter
public class WeaponPropertyComposition // "Properties"
		implements Composition<WeaponPropertyComposition> {
	@Singular("properties")
	private Set<WeaponPropertyOption> content;

	private AmmunitionOption ammunitionType;
	private MeasureComponent normalRange;
	private MeasureComponent longRange;
	private DiceOption versatileDice;

	public void update(WeaponPropertyComposition clone) {
		this.content.clear();
		this.content.addAll(clone.content);
		this.ammunitionType = clone.ammunitionType;
		this.normalRange = clone.normalRange;
		this.longRange = clone.longRange;
		this.versatileDice = clone.versatileDice;
	}
}
