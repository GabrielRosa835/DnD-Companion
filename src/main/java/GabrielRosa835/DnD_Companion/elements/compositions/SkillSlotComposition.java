package elements.compositions;

import elements.components.slots.*;
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
public class SkillSlotComposition implements
		Effect.Applicable<SkillSlotComposition>,
		Composition<Skill, SkillSlot>,
		Character.Property
{
	private final Character character;

	@Singular("skill")
	private Map<Skill, SkillSlot> skillMapping = new HashMap<>();

	@Override
	public SkillSlot get(Skill type) {
		return skillMapping.get(type);
	}
	@Override
	public SkillSlotComposition add(SkillSlot skillSlot) {
		skillMapping.putIfAbsent(skillSlot.type(), skillSlot);
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
