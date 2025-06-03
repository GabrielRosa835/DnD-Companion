package app.domain.elements.variants;

import app.domain.elements.components.*;
import app.domain.elements.options.characterOptions.*;
import app.domain.elements.options.system.*;

import java.util.*;

public interface IsPerson extends IsPhysicsObject {
	String name();

	HealthComponent health();
	int initiative();
	int armorClass();
	Race race();
	Background background();
	EquipmentComponent equipment();

	Map<SpeedType, MeasureComponent> speed();
	Map<AbilityScoreType, CompositeAbilityScoreComponent> status();
	Map<Skill, SkillProficiencyComponent> skills();
	Map<IsItem, ItemAmountComponent> inventory();
	Map<Language, ProficiencyType> languageProficiencies();

	List<Sense> senses();

	int proficiencyBonus();

	String behavioralDescription();
	String visualDescription();
	Alignment alignment();
}
