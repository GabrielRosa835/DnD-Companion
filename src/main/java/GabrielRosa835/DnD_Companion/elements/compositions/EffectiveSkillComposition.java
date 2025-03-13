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
@Getter
@Accessors(fluent = true)
public class EffectiveSkillComposition implements
		Effect.Applicable<EffectiveSkillComposition>,
		Composition<Skill, EffectiveSkill>,
		Character.Property
{
	private final Character character;

	private Map<Skill, EffectiveSkill> skillMapping = new HashMap<>();

	public EffectiveSkill get(Skill type) {
		return skillMapping.get(type);
	}
	public EffectiveSkillComposition add(EffectiveSkill effectiveSkill) {
		skillMapping.putIfAbsent(effectiveSkill.type(), effectiveSkill);
		return this;
	}
	public EffectiveSkillComposition remove(Skill skill) {
		skillMapping.remove(skill);
		return this;
	}

	public void applyEffect(Effect<EffectiveSkillComposition> effect) {
		EffectiveSkillComposition result = effect.applyTo(this);
		this.skillMapping.putAll(result.skillMapping);
	}
}
