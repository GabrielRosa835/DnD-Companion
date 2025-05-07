package app.domain.elements.entities;

import app.domain.elements.components.*;
import app.domain.elements.components.playerCharacter.*;
import app.domain.elements.models.types.*;
import app.domain.elements.options.*;
import app.experimental.*;
import app.storage.reference.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@With
public record PlayerCharacter(
		String name,
		@AsReference Player player,

		HealthComponent health,
		boolean inspiration,
		@AsReference Race race,
		@AsReference Background background,
		int experience,
		DeathSaveComponent[] deathSaves,
		@JsonManagedReference EquipmentComponent equipment,
		@AsReference Size size,
		int attunementLimit,
		int proficiencyBonus,
		@AsReference Dice hitDiceType,
		int hitDiceLeft,

		Map<Speed, MeasureComponent> speed,
		Map<PlayerClass, PlayerClassComponent> classes,
		Map<AbilityScoreType, AbilityScoreComponent> status,
		Map<Skill, SkillComponent> skills,
		Map<Item, ItemComponent> inventory,
		Map<Tool, Proficiency> toolProficiencies,
		Map<Language, Proficiency> languageProficiencies,
		Map<WeaponCategory, Proficiency> weaponProficiencies,
		Map<ArmorCategory, Proficiency> armorProficiencies,
		List<Sensing> senses,

		String behavioralDescription,
		String visualDescription,
		Alignment alignment,
		MeasureComponent height,
		MeasureComponent weight,
		int age,
		Sex sex,
		Gender gender,
		Religion faith,
		List<String> personalityTraits,
		List<String> ideals,
		List<String> bonds,
		List<String> flaws,
		String backstory,
		List<NoteComponent> notes
) implements Person {
	public int initiative() {return 0;}
	public int armorClass() {return 0;}
	public int level() {return 0;}

	public interface Property {
		PlayerCharacter backToCharacter();
	}
}
