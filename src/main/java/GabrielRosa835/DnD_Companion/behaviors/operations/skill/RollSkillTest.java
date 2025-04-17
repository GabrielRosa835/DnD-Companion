<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/skill/RollSkillTest.java
package GabrielRosa835.dnd_companion.app.tactics.operations.skill;
========
package behaviors.operations.skill;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/skill/RollSkillTest.java


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/skill/RollSkillTest.java
========
import behaviors.*;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/skill/RollSkillTest.java

@AllArgsConstructor
public class RollSkillTest implements Operation<Integer>
{
	private int skillModifier;

	public static int with(int skillModifier) {
      new RollSkillTest(skillModifier);
      return execute();
	}
	public static int with(SkillGroup group) {
		int skillModifier = group.modifier();
      new RollSkillTest(skillModifier);
      return execute();
	}

	public Integer execute() {
		return Dice.D20.roll() + skillModifier;
	}
}
