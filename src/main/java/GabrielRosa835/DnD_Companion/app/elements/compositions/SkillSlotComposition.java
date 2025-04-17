package elements.compositions;

import elements.components.groups.*;
import elements.entities.character.Character;
import elements.entities.character.Skill;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class SkillSlotComposition implements
		Effect.Applicable<SkillSlotComposition>,
		Composition<Skill, SkillGroup>,
		Character.Property
{
	private final Character character;

	@Singular("skill")
	private Map<Skill, SkillGroup> skillMapping = new HashMap<>();

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
