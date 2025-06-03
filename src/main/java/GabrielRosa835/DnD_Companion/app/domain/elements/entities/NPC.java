package app.domain.elements.entities;

import app.domain.elements.components.*;
import app.domain.elements.options.characterOptions.*;
import app.domain.elements.options.system.*;
import app.domain.elements.variants.*;
import app.utilities.*;

import java.util.*;

public record NPC (
		String name,
		HealthComponent health,
		Race race,
		Background background,
		EquipmentComponent equipment,
		Map<Speed, MeasureComponent> speed,
		Map<AbilityScoreType, AbilityScoreComponent> status,
		Map<Skill, SkillProficiencyComponent> skills,
		Map<IsItem, ItemAmountComponent> inventory,
		Map<Language, ProficiencyType> languageProficiencies,
		List<Sensing> senses,
		int proficiencyBonus,
		String behavioralDescription,
		String visualDescription,
		Alignment alignment,
		Size size,
		List<NoteComponent> notes
) implements IsPerson {

	@Override public int initiative() {return 0;}

	@Override public int armorClass() {return 0;}
}
