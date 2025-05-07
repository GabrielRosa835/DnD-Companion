package app.domain.elements.components.playerCharacter;

import app.domain.elements.components.*;
import app.domain.elements.entities.*;
import app.domain.elements.models.types.*;
import app.experimental.*;
import app.storage.reference.*;
import com.fasterxml.jackson.annotation.*;

import java.util.*;

public record InventoryComponent(
		Map<Unit, MeasureComponent> savings,
		@AsReference Map<Item, ItemComponent> items,
		@JsonIgnore PlayerCharacter backToCharacter
) implements PlayerCharacter.Property {

	public double totalSavings() {return 0;}

	public double weightCarried() {return 0;}

	public double encumberedLimit() {return 0;}

	public double pushDragLiftLimit() {return 0;}

}
