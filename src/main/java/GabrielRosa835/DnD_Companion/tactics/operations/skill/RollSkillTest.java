package tactics.operations.skill;

import elements.components.effective.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class RollSkillTest implements Operation<Integer>
{
	private EffectiveSkill effectiveSkill;

	public Integer execute() {
		return Dice.D20.roll() + effectiveSkill.modifier();
	}
}
