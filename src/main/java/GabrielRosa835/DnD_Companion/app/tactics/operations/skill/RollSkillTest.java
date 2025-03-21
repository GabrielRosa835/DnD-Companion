package GabrielRosa835.dnd_companion.app.tactics.operations.skill;


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;

@AllArgsConstructor
public class RollSkillTest implements Operation<Integer>
{
	private int skillModifier;

	public static int with(int skillModifier) {
		return new RollSkillTest(skillModifier).execute();
	}
	public static int with(SkillGroup group) {
		int skillModifier = group.modifier();
		return new RollSkillTest(skillModifier).execute();
	}

	public Integer execute() {
		return Dice.D20.roll() + skillModifier;
	}
}
