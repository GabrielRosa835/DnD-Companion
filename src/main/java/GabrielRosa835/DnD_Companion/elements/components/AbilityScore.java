package elements.components;

import elements.models.Component;
import lombok.*;
import lombok.experimental.*;
import operational.*;
import tactics.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class AbilityScore implements Component, Effect.Applicable {
	private Character character;

	private Type type;
	private int value; // floor(value/3) - 5
	private int modifier;

	private boolean savingThrowProficiency;

	public int rollTest() {
		return Dice.Standard.D20.roll() + modifier;
	}

	public int rollTestWithProficiency(boolean proficiency) {
		int proficiencyModifier = proficiency ? character.proficiencyBonus() : 0;
		return rollTest() + proficiencyModifier;
	}

	public int rollSave() {
		return rollTestWithProficiency(savingThrowProficiency);
	}

	public enum Type {
		STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA
	}

	public AbilityScore applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this);
		this.character = e.changeCharacter();
		this.type = e.changeType();
		this.value = e.changeValue();
		this.modifier = e.changeModifier();
		this.savingThrowProficiency = e.changeSavingThrowProficiency();
		return this;
	}

	public interface Effect extends tactics.Effect {
		Character changeCharacter();
		Type changeType();
		int changeValue();
		int changeModifier();
		boolean changeSavingThrowProficiency();
	}
}
