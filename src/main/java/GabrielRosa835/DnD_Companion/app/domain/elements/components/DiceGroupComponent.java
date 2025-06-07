package app.domain.elements.components;

import app.domain.elements.entities.options.system.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record DiceGroupComponent (
		int amount,
		@ManyToOne
		Dice dice
) {
}
