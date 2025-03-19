package tactics.operations.skill;

import elements.components.slots.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollSkillTest implements Operation<Integer>
{
	private SkillSlot skillSlot;

	public static RollSkillTest use() {
		return new RollSkillTest();
	}

	public Integer execute() {
		return Dice.D20.roll() + skillSlot.modifier();
	}
}
