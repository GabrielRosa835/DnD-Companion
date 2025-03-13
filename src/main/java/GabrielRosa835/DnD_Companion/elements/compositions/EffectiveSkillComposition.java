package elements.compositions;

import elements.components.effective.*;
import elements.entities.Character;
import elements.entities.options.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class EffectiveSkillComposition implements
		Effect.Applicable<EffectiveSkillComposition>,
		Composition<Skill, EffectiveSkill>,
		Character.Property
{
	private final Character character;

	@Singular("skill")
	private Map<Skill, EffectiveSkill> skillMapping = new HashMap<>();

	@Override
	public EffectiveSkill get(Skill type) {
		return skillMapping.get(type);
	}
	@Override
	public EffectiveSkillComposition add(EffectiveSkill effectiveSkill) {
		skillMapping.putIfAbsent(effectiveSkill.type(), effectiveSkill);
		return this;
	}
	@Override
	public EffectiveSkillComposition remove(Skill skill) {
		skillMapping.remove(skill);
		return this;
	}

	@Override
	public EffectiveSkillComposition applyEffect(Effect<EffectiveSkillComposition> effect) {
		var result = effect.applyTo(this);
		this.skillMapping.putAll(result.skillMapping);
		return this;
	}
}
