package GabrielRosa835.compositions;

import GabrielRosa835.*;
import GabrielRosa835.components.*;
import GabrielRosa835.models.*;

import java.util.*;

public class SkillComposition implements Component, Effectable, Composition<Skill>
{
	private Map<Skill.Type, Skill> skillMapping = new HashMap<>();

	public Skill get(Skill.Type type) {
		return skillMapping.get(type);
	}
	public Composition<Skill> add(Skill skill) {
		skillMapping.putIfAbsent(skill.type(), skill);
		return this;
	}

	public Skill athletics() {return get(Skill.Type.ATHLETICS);}

	public SkillComposition applyEffect(GabrielRosa835.Effect effect) {
		SkillComposition.Effect e = (SkillComposition.Effect) effect;
		e.loadObject(this);
		this.skillMapping = e.changeSkillMapping();
		return this;
	}
	public interface Effect extends GabrielRosa835.Effect {
		Map<Skill.Type, Skill> changeSkillMapping();
	}
}
