package tactics.operations.skill;

import elements.components.effective.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollSkillTest implements Operation<Integer>
{
	private EffectiveSkill effectiveSkill;

	public static RollSkillTest use() {
		return new RollSkillTest();
	}

	public Integer execute() {
		return Dice.D20.roll() + effectiveSkill.modifier();
	}
}
