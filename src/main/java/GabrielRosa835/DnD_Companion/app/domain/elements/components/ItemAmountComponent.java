package app.domain.elements.components;

import app.domain.elements.options.items.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record ItemAmountComponent(
		Item type,
		int amount
) {}
