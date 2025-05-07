package app.domain.elements.entities;

import app.domain.elements.components.*;
import app.domain.elements.components.playerCharacter.*;
import app.domain.elements.models.types.*;
import app.domain.elements.options.*;

import java.util.*;

public record NPC (
		String name,
		HealthComponent health,
		Race race,
		Background background,
		EquipmentComponent equipment,
		Map<Speed, MeasureComponent> speed,
		Map<AbilityScoreType, AbilityScoreComponent> status,
		Map<Skill, SkillComponent> skills,
		Map<Item, ItemComponent> inventory,
		Map<Language, Proficiency> languageProficiencies,
		List<Sensing> senses,
		int proficiencyBonus,
		String behavioralDescription,
		String visualDescription,
		Alignment alignment,
		Size size,
		List<NoteComponent> notes
) implements Person {

	@Override public int initiative() {return 0;}

	@Override public int armorClass() {return 0;}
}
