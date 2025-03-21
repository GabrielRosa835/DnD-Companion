package GabrielRosa835.dnd_companion.app.elements.compositions;

import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class SkillSlotComposition implements
		Effect.Applicable<SkillSlotComposition>,
		Composition<Skill, SkillGroup>,
		Character.Property
{
	private Character character;

	@Singular("skill")
	private Map<Skill, SkillGroup> skillMapping;

	@Override
	public SkillGroup get(Skill type) {
		return skillMapping.get(type);
	}
	@Override
	public SkillSlotComposition add(SkillGroup skillGroup) {
		skillMapping.putIfAbsent(skillGroup.type(), skillGroup);
		return this;
	}
	@Override
	public SkillSlotComposition remove(Skill skill) {
		skillMapping.remove(skill);
		return this;
	}

	@Override
	public SkillSlotComposition applyEffect(Effect<SkillSlotComposition> effect) {
		var result = effect.applyTo(this);
		this.skillMapping = result.skillMapping;
		return this;
	}
}
