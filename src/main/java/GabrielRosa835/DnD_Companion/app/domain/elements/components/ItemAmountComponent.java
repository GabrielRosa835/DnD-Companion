package app.domain.elements.components;

import app.domain.elements.entities.options.items.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record ItemAmountComponent(
		@ManyToOne (fetch = FetchType.LAZY)
		Item item,

		int amount
) {}
