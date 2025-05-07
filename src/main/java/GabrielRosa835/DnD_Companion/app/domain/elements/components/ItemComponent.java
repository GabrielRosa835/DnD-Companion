package app.domain.elements.components;

import app.domain.elements.models.types.Item;
import lombok.*;
import lombok.experimental.Accessors;

@With
public record ItemComponent (
		Item type,
		int amount
) {}
