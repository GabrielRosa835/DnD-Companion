package elements.compositions;

import elements.components.character.Skill;
import elements.models.*;
import tactics.*;

import java.util.*;

public class SkillComposition implements Effect.Applicable, Composition<Skill> {
	private Map<Skill.Type, Skill> skillMapping = new HashMap<>();

	public Skill get(Skill.Type type) {
		return skillMapping.get(type);
	}

	public Composition<Skill> add(Skill skill) {
		skillMapping.putIfAbsent(skill.type(), skill);
		return this;
	}

	public Skill athletics() {
		return get(Skill.Type.ATHLETICS);
	}

	public SkillComposition applyEffect(tactics.Effect effect) {
		SkillComposition.Effect e = (SkillComposition.Effect) effect;
		e.loadObject(this);
		this.skillMapping = e.changeSkillMapping();
		return this;
	}

	public interface Effect extends tactics.Effect {
		Map<Skill.Type, Skill> changeSkillMapping();
	}
}
