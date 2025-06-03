package app.domain.elements.components;

import app.domain.elements.options.items.*;
import app.domain.elements.variants.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Embeddable
@With
public record EquipmentComponent(
		Armor currentArmor,
		Map<Integer, Item> heldItems,
		Map<String, Item> attunedMagicItems
) {}
