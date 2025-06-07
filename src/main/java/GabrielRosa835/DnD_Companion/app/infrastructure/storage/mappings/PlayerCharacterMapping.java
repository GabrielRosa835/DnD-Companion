package app.infrastructure.storage.mappings;

import app.experimental.*;
import app.infrastructure.storage.*;
import app.infrastructure.storage.mappings.associations.*;
import app.infrastructure.storage.mappings.options.characterOptions.*;
import app.infrastructure.storage.mappings.options.items.*;
import app.infrastructure.storage.mappings.options.system.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter
@Entity
@Table (name = "ent_player_characters")
public class PlayerCharacterMapping implements Persistent<Short> {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Short id;

	@Column (unique = true)
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	PlayerMapping playerMapping;

	// HEALTH
	short maximumHitPoints;
	short currentHitPoints;
	short temporaryHitPoints;

	@ElementCollection
	List<DeathSaveTypeMapping> deathsaves = new ArrayList<>();

	@ManyToOne
	DiceMapping hitDiceType;
	short hitDiceLeft;
	// HEALTH

	// IDENTITY
	@ManyToOne
	RaceMapping race;

	@ManyToOne
	BackgroundMapping background;

	@ManyToOne
	SizeCategoryMapping size;

	@ManyToOne
	SexMapping sex;

	@ManyToOne
	GenderMapping gender;

	@ManyToOne
	ReligionMapping faith;

	@Column (columnDefinition = "TEXT")
	String behavioralDescription;

	@Column (columnDefinition = "TEXT")
	String visualDescription;

	@Column (columnDefinition = "TEXT")
	String backstory;

	@ManyToOne
	AlignmentMapping alignment;

	@ManyToOne
	UnitMapping heightUnit;
	float heightValue;

	@ManyToOne
	UnitMapping weightUnit;
	float weightValue;

	int age;
	// IDENTITY

	// BASE PERSONALITY
	@ElementCollection (fetch = FetchType.LAZY)
	List<String> personalityTraits = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	List<String> ideals = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	List<String> bonds = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	List<String> flaws = new ArrayList<>();
	// BASE PERSONALITY

	// PROFICIENCIES
	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterArmorProficienciesAssociation> armors = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterWeaponProficienciesAssociation> weapons = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterSkillProficienciesAssociation> skills = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterLanguageProficienciesAssociation> languages = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterToolProficienciesAssociation> tools = new ArrayList<>();
	// PROFICIENCIES

	// EQUIPMENT
	@ManyToOne
	ArmorMapping currentArmor;

	@ElementCollection (fetch = FetchType.LAZY)
	List<Wealth> wealth = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	List<Items> inventory = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<ItemMapping> attunedMagicItems = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterHeldItemsAssociation> heldItems = new ArrayList<>();
	// EQUIPMENT

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterSpeedAssociation> speeds = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterClassAssociation> classes = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<CharacterAbilityScoreAssociation> status = new ArrayList<>();

	@OneToMany (fetch = FetchType.LAZY)
	List<SenseMapping> senses = new ArrayList<>();

	int experience;
	boolean inspiration;

	@Embeddable
	private record Wealth(@ManyToOne UnitMapping unit, float amount) {}

	@Embeddable
	public record Items(@ManyToOne ItemMapping item, int amount) {}
}