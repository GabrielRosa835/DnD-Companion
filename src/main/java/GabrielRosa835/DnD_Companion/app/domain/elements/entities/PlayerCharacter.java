package app.domain.elements.entities;

import app.domain.elements.components.*;
import app.domain.elements.options.characterOptions.*;
import app.domain.elements.options.items.*;
import app.domain.elements.options.system.*;
import app.domain.elements.variants.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor (staticName = "create")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Builder (setterPrefix = "with")
@Getter
@Entity
@Table (name = "ent_player_characters")
public class PlayerCharacter implements DomainElement {
	@Id
	String name;

	@Column (columnDefinition = "TEXT")
	String description;

	@ManyToOne
	Player player;

	@Embedded
	HealthComponent health;

	@ElementCollection (fetch = FetchType.LAZY)
	@CollectionTable (name = "rel_character_deathsaves")
	@Enumerated (EnumType.STRING)
	List<DeathSave> deathsaves = new ArrayList<>();

	@Embedded
	DiceGroupComponent hitDice;

	@ManyToOne
	Race race;

	@ManyToOne
	Background background;

	@Embedded
	EquipmentComponent equipment;

	@ManyToOne
	SizeCategory size;

	@Column (columnDefinition = "TEXT")
	String behavioralDescription;
	@Column (columnDefinition = "TEXT")
	String visualDescription;
	@Column (columnDefinition = "TEXT")
	String backstory;

	@ManyToOne
	Alignment alignment;

	@Embedded
	MeasureComponent height;
	@Embedded
	MeasureComponent weight;

	@ManyToOne
	Sex sex;
	@ManyToOne
	Gender gender;
	@ManyToOne
	Religion faith;

	@ElementCollection (fetch = FetchType.LAZY)
	@CollectionTable (name = "rel_character_personality_traits")
	@Column (columnDefinition = "TEXT")
	List<String> personalityTraits = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@CollectionTable (name = "rel_character_ideals")
	@Column (columnDefinition = "TEXT")
	List<String> ideals = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@CollectionTable (name = "rel_character_bonds")
	@Column (columnDefinition = "TEXT")
	List<String> bonds = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@CollectionTable (name = "rel_character_flaws")
	@Column (columnDefinition = "TEXT")
	List<String> flaws = new ArrayList<>();

	@ManyToMany
	List<Sense> senses = new ArrayList<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@MapKeyClass (SpeedType.class)
	@Embedded
	Map<SpeedType, MeasureComponent> speed = new HashMap<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@MapKeyClass (CharacterClass.class)
	@Embedded
	Map<CharacterClass, CompositePlayerClassComponent> classes = new HashMap<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@MapKeyClass (AbilityScoreType.class)
	@Embedded
	Map<AbilityScoreType, CompositeAbilityScoreComponent> status = new HashMap<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@MapKeyClass (Item.class)
	@Embedded
	Map<Unit, MeasureComponent> wealth = new HashMap<>();

	@ElementCollection (fetch = FetchType.LAZY)
	@MapKeyClass (Item.class)
	@Embedded
	Map<Item, ItemAmountComponent> inventory = new HashMap<>();

	@Embedded
	CharacterProficienciesComponent proficiencies;

	int age;
	boolean inspiration;
	int experience;
}

