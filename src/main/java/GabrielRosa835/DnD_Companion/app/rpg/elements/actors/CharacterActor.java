package app.rpg.elements.actors;

import app.rpg.elements.components.*;
import app.rpg.elements.compositions.*;
import app.rpg.models.Actor;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class CharacterActor
	implements Actor<CharacterActor>
{
	private CharacterDecorationPropertiesComponent decorationProperties;
	private CharacterKeyPropertiesComponent keyProperties;
	private CharacterClassComposition classes;
	private HealthComponent healthComponent;
	private AbilityScoreComposition status;
	private EquipmentComponent equipment;
	private ItemComposition belongings;
	private SkillComposition skills;
	private String name;

	@Override public void update(CharacterActor clone) {
		this.decorationProperties = clone.decorationProperties;
		this.healthComponent = clone.healthComponent;
		this.keyProperties = clone.keyProperties;
		this.belongings = clone.belongings;
		this.equipment = clone.equipment;
		this.classes = clone.classes;
		this.status = clone.status;
		this.skills = clone.skills;
		this.name = clone.name;
	}
}
