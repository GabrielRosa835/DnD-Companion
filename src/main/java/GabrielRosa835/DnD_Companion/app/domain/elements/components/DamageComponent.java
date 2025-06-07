package app.domain.elements.components;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Embeddable
@With
public record DamageComponent (
		@ElementCollection
		@Embedded
		List<DiceGroupComponent> dices,

		@ManyToOne
		app.domain.elements.entities.options.system.DamageTypeMapping type,

		int modifier
) {}
