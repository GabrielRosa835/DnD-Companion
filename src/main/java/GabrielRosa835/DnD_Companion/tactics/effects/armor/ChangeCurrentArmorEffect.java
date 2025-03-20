package tactics.effects.armor;

import elements.entities.items.Armor;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class ChangeCurrentArmorEffect implements
		Effect<ArmorSlot>
{
	private Armor armor;


}
