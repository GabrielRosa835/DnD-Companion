package app.domain.elements.components.playerCharacter;

import app.domain.elements.entities.*;
import app.domain.elements.models.types.*;
import app.domain.elements.options.*;
import app.storage.reference.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@With
public record EquipmentComponent (
		@AsReference Armor currentArmor,
		@AsReference Map<Integer, Item> heldItems,
		@AsReference List<Item> attunedMagicItems,
		@JsonBackReference PlayerCharacter backToCharacter
) implements PlayerCharacter.Property {}
