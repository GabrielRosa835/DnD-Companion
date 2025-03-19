package tactics.effects.armor;

import elements.components.slots.*;
import elements.entities.options.*;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class ChangeCurrentArmorEffect implements
		Effect<ArmorSlot>
{
	private Armor armor;


}
