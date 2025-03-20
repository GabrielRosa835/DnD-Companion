package tactics.operations.skill;

import elements.components.groups.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

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
	public static

	public Integer execute() {

		return Dice.D20.roll() + skillModifier;
	}
}
