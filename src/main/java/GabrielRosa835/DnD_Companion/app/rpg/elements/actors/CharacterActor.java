package app.rpg.elements.actors;

import app.rpg.elements.components.*;
import app.rpg.elements.compositions.*;
import app.rpg.elements.models.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Accessors(fluent = true)
@ToString
@Builder(setterPrefix = "with")
@Getter
public class CharacterActor implements Actor<CharacterActor>
{
	private String name;
	private HealthComponent health;
	private CharacterClassComposition classes;
	private AbilityScoreComposition status;
	private SkillComposition skills;
	private ItemComposition inventory;
	private EquipmentComponent equipment;
	private CharacterKeyPropertiesComponent keyProperties;
	private CharacterDecorationPropertiesComponent decorationProperties;
	private CatalystComposition resistances;

	@Override public CharacterActor update(CharacterActor clone) {
		this.decorationProperties = clone.decorationProperties;
		this.keyProperties = clone.keyProperties;
		this.inventory = clone.inventory;
		this.equipment = clone.equipment;
		this.classes = clone.classes;
		this.status = clone.status;
		this.skills = clone.skills;
		this.health = clone.health;
		this.name = clone.name;
		return this;
	}
	@Override public CharacterActor replicate() {
		return new CharacterActor().update(this);
	}
}
